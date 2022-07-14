* Docker for avatica server https://github.com/apache/calcite-avatica/blob/main/docker/src/main/docker/mysql/Dockerfile
* Example client https://codetinkering.com/apache-calcite-tutorial/
* Some jdbc strings https://docs.imply.io/saas/query-jdbc/
  * Ueseless https://stackoverflow.com/questions/53526650/avatica-calcite-jdbc-driver-issue
  * Weird https://guxd.github.io/codekernel/samples/DriverManager.getConnection/cluster0.html
<pre>
Class1230.beforeClass()#0{
    start = Main.start(new String[]{Factory.class.getName()});
    final int port = start.getPort();
    remoteConnection = DriverManager.getConnection(
        "jdbc:avatica:remote:url=http://localhost:" + port);
}
</pre>

Connection with curl
<pre>
curl -k http://localhost:8765 -H "Content-Type: application/json" -d '{
  "request": "openConnection",
  "connectionId": "123",
  "info": {
    "user": "root",
    "password": "avatica"
  }
}'
</pre>