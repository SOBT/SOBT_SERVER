package com.sobt.project.jython.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.junit.Test;
import org.python.core.*;
import org.python.util.PythonInterpreter;

import sobt.domain.python.Papago;

public class jythonTest {
	@Test
	public void basic() throws PyException {
		// Create an instance of the PythonInterpreter
		PythonInterpreter interp = new PythonInterpreter();

		// The exec() method executes strings of code
		interp.exec("import sys");
		interp.exec("print sys");

		// Set variable values within the PythonInterpreter instance
		interp.set("a", new PyInteger(42));
		interp.exec("print a");
		interp.exec("x = 2+2");

		// Obtain the value of an object from the PythonInterpreter and store it
		// into a PyObject.
		PyObject x = interp.get("x");
		System.out.println("x: " + x);
	}

	@Test
	public void papago_test(){
		Papago papago = new Papago();
		String s = papago.translate("안녕하세요. 저는 바보입니다.", "True");
		System.out.println(s);
		s = papago.translate("니가 그렇게 번역을 잘해?", "True");
		System.out.println(s);
	}
}
