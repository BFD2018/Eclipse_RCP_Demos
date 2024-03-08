package com.xiong.myrcp01.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Display;

import com.xiong.myrcp01.dialog.TestDataBindingDialog;

public class TestDataBindingHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		TestDataBindingDialog dialog = new TestDataBindingDialog(Display.getCurrent().getActiveShell());
		int open = dialog.open();

		return open;
	}

}
