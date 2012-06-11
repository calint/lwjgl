jgl=$HOME/sdk/lwjgl/lwjgl-2.8.4
lib=$jgl/native/macosx/
#
app=$*
bin=bin
jar=$jgl/jar
cp=$bin:$jar/lwjgl.jar:$jar/lwjgl_util.jar
echo $app
echo $jar
echo $lib
java -cp $cp -Djava.library.path=$lib $app

