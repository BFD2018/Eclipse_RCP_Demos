package com.xiong.myrcp01.forms.advance;

import java.io.File;
import java.util.Date;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

public class DirectoryDetailPage implements IDetailsPage {

	private IManagedForm mform;
	private File file;
	private Section fileSection;
	private Text fileName;
	private Text filePath;
	private Text lastModify;
	private Button isRead;
	private Button isWrite;
	private Composite client;

	public void createContents(Composite parent) {
		// ���ø������Ĳ���
		TableWrapLayout layout = new TableWrapLayout();
		layout.topMargin = 5;
		layout.leftMargin = 5;
		layout.rightMargin = 2;
		layout.bottomMargin = 2;
		parent.setLayout(layout);
		// ��ñ������߶���
		FormToolkit toolkit = mform.getToolkit();
		// ����Detail��������
		fileSection = toolkit.createSection(parent, Section.DESCRIPTION | Section.TITLE_BAR);
		TableWrapData td = new TableWrapData(TableWrapData.FILL, TableWrapData.TOP);
		td.grabHorizontal = true;
		fileSection.setLayoutData(td);
		// �����������������õ����
		client = toolkit.createComposite(fileSection);
		fileSection.setClient(client);
		GridLayout gridLayout = new GridLayout();
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.numColumns = 2;
		gridLayout.horizontalSpacing = 10;
		client.setLayout(gridLayout);
		// ����Detail���־���ĸ��ֿؼ�
		toolkit.createLabel(client, "����:");
		fileName = toolkit.createText(client, "");
		toolkit.createLabel(client, "·��:");
		filePath = toolkit.createText(client, "");
		toolkit.createLabel(client, "����޸�:");
		lastModify = toolkit.createText(client, file != null ? new Date(file.lastModified()).toLocaleString() : "");
		isRead = toolkit.createButton(client, "�Ƿ�ɶ�", SWT.CHECK);
		isWrite = toolkit.createButton(client, "�Ƿ��д", SWT.CHECK);

	}

	public void initialize(IManagedForm form) {
		this.mform = form;
	}

	public void dispose() {

	}

	public boolean isDirty() {
		return false;
	}

	public void commit(boolean onSave) {

	}

	public boolean setFormInput(Object input) {

		return false;
	}

	public void setFocus() {

	}

	public boolean isStale() {
		return false;
	}

	public void refresh() {

	}

	// ��Master����ѡ���¼�����ʱ
	public void selectionChanged(IFormPart part, ISelection selection) {
		// ���Ȼ��ѡ�еĶ���
		IStructuredSelection currentSelection = (IStructuredSelection) selection;
		if (currentSelection.size() == 1)
			file = (File) currentSelection.getFirstElement();
		// ���ѡ�еĶ���Ϊnull,��ˢ�¿ؼ�����ʾ��ֵ
		if (file != null)
			update();
	}

	// ˢ��ֵ
	public void update() {
		// ���ѡ�е�Ϊ�ļ���
		if (file.isDirectory()) {
			fileSection.setText("�ļ���");
			fileSection.setDescription("����һ���ļ���");
		} else {// ����
			fileSection.setText("�ļ�");
			fileSection.setDescription("����һ���ļ�");
		}
		// �����ļ���
		fileName.setText(file.getName());
		// ����·��
		filePath.setText(file.getAbsolutePath());
		// �����ϴ��޸�
		lastModify.setText(new Date(file.lastModified()).toLocaleString());
		// �����Ƿ�ֻ��
		isRead.setSelection(file.canRead());
		// �����Ƿ��д
		isWrite.setSelection(file.canWrite());
	}
}
