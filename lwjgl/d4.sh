jgl="$HOME/sdk/lwjgl/lwjgl-2.8.4"
jar="$jgl/jar"
lib="$jgl/native/macosx/"
app="d4.app"
echo $jar
echo $lib
echo $app
java -cp bin:$jar/lwjgl.jar:$jar/lwjgl_util.jar -Djava.library.path=$lib $app

