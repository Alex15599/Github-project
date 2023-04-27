docker build -f ./bpmDockerfile .
exit 0
docker run -d --name app_bpm -p 30004:8099 bpm:latest
