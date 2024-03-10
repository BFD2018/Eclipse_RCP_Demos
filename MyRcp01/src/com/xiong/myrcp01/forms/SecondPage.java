package com.xiong.myrcp01.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

public class SecondPage extends FormPage {

	public static final String ID = "com.fengmanfei.myrcp.forms.SecondPage";

	public SecondPage(FormEditor editor) {
		super(editor, ID, "�ڶ�ҳ");
	}

	protected void createFormContent(IManagedForm managedForm) {
		ScrolledForm form = managedForm.getForm();
		form.setText("ColumnLayout");
		// �����в���
		ColumnLayout layout = new ColumnLayout();
		layout.topMargin = 0;// �ϲ���
		layout.bottomMargin = 5;// �²���
		layout.leftMargin = 10;// �󲹰�
		layout.rightMargin = 10;// �Ҳ���
		layout.horizontalSpacing = 10;// ˮƽ����ؼ��ľ���
		layout.verticalSpacing = 10;// ��ֱ����ؼ��ľ���
		layout.maxNumColumns = 4;// ��������
		layout.minNumColumns = 1;// ��С������
		form.getBody().setLayout(layout);// ���ñ����Ĳ���Ϊ�в���
		// �����ĸ�������
		for (int i = 0; i < 4; i++)
			createSectionWithLinks(managedForm, "Section" + i, "This is Section " + i, i);
	}

	// ��������������ؼ�
	private void createSectionWithLinks(IManagedForm mform, String title, String desc, int nlinks) {
		// ��������ȥ���
		Composite client = createSection(mform, title, desc, 1);
		FormToolkit toolkit = mform.getToolkit();
		// �����������еĿؼ�
		for (int i = 1; i <= nlinks; i++)
			toolkit.createHyperlink(client, "link" + i, SWT.WRAP);
	}

	// �����������ķ���
	private Composite createSection(IManagedForm mform, String title, String desc, int numColumns) {
		final ScrolledForm form = mform.getForm();
		FormToolkit toolkit = mform.getToolkit();
		// ����������
		Section section = toolkit.createSection(form.getBody(),
				Section.TWISTIE | Section.TITLE_BAR | Section.DESCRIPTION | Section.EXPANDED);
		section.setText(title);
		section.setDescription(desc);
		Composite client = toolkit.createComposite(section);
		GridLayout layout = new GridLayout();
		layout.marginWidth = layout.marginHeight = 0;
		layout.numColumns = numColumns;
		client.setLayout(layout);
		// ���������������
		section.setClient(client);
		section.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(false);
			}
		});
		return client;
	}
}
