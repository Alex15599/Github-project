<%@ page contentType="image/jpeg" pageEncoding="utf-8"%>
<%@ page
	import="java.awt.*,java.awt.image.*,java.util.*,javax.imageio.*,java.io.*"%>
<%!//在确定的范围内获得随机颜色
	Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
}%>

<%
	response.setHeader("Pragma","No-cache");//设置页面不缓存
	response.setHeader("Cache-Control","no-cache");
	response.setDateHeader("Expires", 0);
	//在内存中创建指定大小的图像
	int width = 50, height = 20;
	BufferedImage image = new BufferedImage(width, height,
			BufferedImage.TYPE_INT_RGB);
	//获得图形上下文
	Graphics g = image.getGraphics();
	//生成随机类
	Random random = new Random();
	//设置背景颜色
	g.setColor(getRandColor(200, 250));
	g.fillRect(0, 0, width, height);
	//设置字体
	g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	g.setColor(getRandColor(160, 200));
	//随机生成50条干扰线，使图形中的验证码不易被其他程序探测到
	for (int i = 0; i < 50; i++) {
		int x = random.nextInt(width);
		int y = random.nextInt(height);
		int xl = random.nextInt(width);
		int yl = random.nextInt(height);
		g.drawLine(x, y, x + xl, y + yl);
	}
	//随机产生4位数的验证码
	String sRand = "";
	for (int i = 0; i < 4; i++) {
		String rand = String.valueOf(random.nextInt(10));
		sRand += rand;
		//验证码显示到图像中
		g.setColor(new Color(20 + random.nextInt(110), 20 + random
				.nextInt(110), 20 + random.nextInt(110)));
		g.drawString(rand, 11 * i + 6, 16);
	}
	//验证码存入SESSION
	session.setAttribute("rand", sRand);
	//图像生效
	g.dispose();
	//输出图像到页面
	try {
		OutputStream os=response.getOutputStream();
		ImageIO.write(image, "JPEG", os);
		os.flush();
		os.close();
		//释放response对象
		response.flushBuffer();
		out.clear();
		out = pageContext.pushBody();
	} catch (RuntimeException e) {
	
	}
%>
