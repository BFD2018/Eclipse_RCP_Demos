package com.xiong.myrcp01.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.MultiPageEditorPart;

public class MutiEditorSample extends MultiPageEditorPart {
	public static final String ID = "com.xiong.myrcp01.editors.MutiEditorSample";
	private JsEditor page1;
	private JsEditor page2;
	private Label control1;

	protected void createPages() {
		page1 = new JsEditor();
		page2 = new JsEditor();
		control1 = new Label(getContainer(), SWT.NONE);
		control1.setText("����һ����ǩ");
		try {
			addPage(page1, new JsEditorInput("One"));
			setPageText(0, "One");
			addPage(page2, new JsEditorInput("Two"));
			setPageText(1, "Two");
			addPage(control1);
			setPageText(2, "Three");
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
