package org.CreadoresProgram.ViaProxyNoCommandRun;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.lang.reflect.Method;
public class Main{
  public static void main(String[] args){
    try{
      File file = new File(System.getProperty("user.dir") + "/ViaProxy.jar");
      URL url = file.toURI().toURL();
      URLClassLoader child = new URLClassLoader(new URL[] { url }, JarLoader.class.getClassLoader());
      Class<?> classToLoad = Class.forName("net.raphimc.viaproxy.ViaProxy", true, child);
      Method method = classToLoad.getDeclaredMethod("main", String[].class);
      method.invoke(null, (Object) getArgsVP());
    }catch(Exception ex){
      ex.printStackTrace();
    }
  }
  public static String[] getArgsVP(){
    File file = new File(System.getProperty("user.dir") + "/viaproxy.yml");
    if(!file.exists()){
      return new String[]{ "cli", "" };
    }
    return new String[]{ "cli" };
  }
}
