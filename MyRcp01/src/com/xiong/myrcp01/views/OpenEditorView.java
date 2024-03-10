package com.xiong.myrcp01.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.internal.part.NullEditorInput;
import org.eclipse.ui.part.ViewPart;

import com.xiong.myrcp01.editors.JsEditor;
import com.xiong.myrcp01.editors.JsEditorInput;
import com.xiong.myrcp01.editors.MutiEditorSample;
import com.xiong.myrcp01.forms.MyMutiForm;

public class OpenEditorView extends ViewPart {
	public static final String ID = "com.fengmanfei.myrcp.views.OpenEditorView";

	public List list;

	public OpenEditorView() {
		super();
	}

	public void createPartControl(Composite parent) {
		list = new List(parent, SWT.NONE);
		list.add("Editor");
		list.add("MutiPage Editor");
		list.add("Form Editor");
		list.add("Master/Detail Page");
		list.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {

				String select = list.getSelection()[0];
				IWorkbenchPage page = getViewSite().getWorkbenchWindow().getActivePage();
				try {
					if (select.equals("Editor")) {
						JsEditorInput editor = new JsEditorInput(select);
						page.openEditor(editor, JsEditor.ID);

					} else if (select.equals("MutiPage Editor")) {
						page.openEditor(new NullEditorInput(), MutiEditorSample.ID);

					} else if (select.equals("Form Editor")) {
						page.openEditor(new NullEditorInput(), MyMutiForm.ID);
					}
				} catch (PartInitException ee) {
					ee.printStackTrace();
				}

			}

		});
	}

	public void setFocus() {
		list.setFocus();
	}
}
