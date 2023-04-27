--profile
/was/IBM/WebSphere/AppServer/bin/manageprofiles.sh -listProfiles
/was/IBM/WebSphere/AppServer/bin/manageprofiles.sh -delete -profileName AppSrv01
/was/IBM/WebSphere/AppServer/bin/manageprofiles.sh -delete -profileName Dmgr01
/was/IBM/WebSphere/AppServer/bin/manageprofiles.sh -validateAndUpdateRegistry
/was/IBM/WebSphere/AppServer/bin/manageprofiles.sh -validateRegistry

--dmgr
/was/IBM/WebSphere/AppServer/profiles/Dmgr01/bin/startManager.sh
/was/IBM/WebSphere/AppServer/profiles/Dmgr01/bin/stopManager.sh

--node
/was/IBM/WebSphere/AppServer/profiles/AppSrv01/bin/addNode.sh  tpl 18103 -username wasadmin -password wasadmin
/was/IBM/WebSphere/AppServer/profiles/AppSrv01/bin/addNode.sh  tpl 8879 -username wasadmin -password wasadmin
/was/IBM/WebSphere/AppServer/profiles/AppSrv01/bin/startNode.sh
/was/IBM/WebSphere/AppServer/profiles/AppSrv01/bin/stopNode.sh -username wasadmin -password wasadmin


