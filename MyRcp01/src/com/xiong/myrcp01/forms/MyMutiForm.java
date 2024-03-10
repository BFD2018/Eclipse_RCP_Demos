package com.xiong.myrcp01.forms;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;

public class MyMutiForm extends FormEditor {

	public static final String ID = "com.fengmanfei.myrcp.forms.MyMutiForm";

	public MyMutiForm() {
		super();
	}

	protected void addPages() {
		try {
			addPage(new FirstPage(this));
			addPage(new SecondPage(this));
			addPage(new MasterDetailPage(this));
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	public void doSave(IProgressMonitor monitor) {
	}

	public void doSaveAs() {
	}

	public boolean isSaveAsAllowed() {
		return false;
	}

}
