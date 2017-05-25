package sobt.domain.python;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.python.core.Py;
import org.python.core.PyString;
import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;

public class Papago {
	PySystemState systemState;
	PythonInterpreter interpreter;
	
	public Papago(){
		systemState = Py.getSystemState();
		systemState.path.append(new PyString("Lib"));
		interpreter = new PythonInterpreter();
		interpreter.exec("import sys");
		interpreter.exec("from Building import papago");
//		interpreter.exec("print sys.path");
	}
	
	public String translate(String sent, String opt){
		try{			
			sent = URLEncoder.encode(sent, "UTF-8");
			interpreter.exec("res = papago('"+sent+"',"+opt+")");
//			interpreter.exec("res = 'Çê¼Ò¸®'");
			PyString x = (PyString)interpreter.eval("res");
			return x.toString();
			
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return sent;
	}
}
