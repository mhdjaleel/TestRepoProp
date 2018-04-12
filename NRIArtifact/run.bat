set projectLocation=D:\NRIautomation\NRIArtifact\

cd %projectLocation%

mvn clean test -DsuiteXmlFile=testng.xml

pause