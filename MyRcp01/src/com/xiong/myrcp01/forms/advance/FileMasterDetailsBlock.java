package com.xiong.myrcp01.forms.advance;

import java.io.File;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.MasterDetailsBlock;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import com.xiong.myrcp01.main.MyRCPActivator;

public class FileMasterDetailsBlock extends MasterDetailsBlock {
	private FormPage page;

	public FileMasterDetailsBlock(FormPage page) {
		this.page = page;
	}

	// �����еĳ��󷽷�������Master����
	protected void createMasterPart(final IManagedForm managedForm, Composite parent) {
		FormToolkit toolkit = managedForm.getToolkit();
		// ����һ��������
		Section section = toolkit.createSection(parent, Section.DESCRIPTION | Section.TITLE_BAR);
		section.setText("����ļ�");
		section.marginWidth = 10;
		section.marginHeight = 5;
		// ���������������
		Composite client = toolkit.createComposite(section, SWT.WRAP);
		// ���Ƹ����ı߿�������ķ��һ��
		toolkit.paintBordersFor(client);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginWidth = 2;
		layout.marginHeight = 2;
		client.setLayout(layout);
		// ����һ������ʹ��toolkit���󴴽�
		Tree tree = toolkit.createTree(client, SWT.NULL);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = 20;
		gd.widthHint = 100;
		tree.setLayoutData(gd);
		/*
		 * IFormPart����������Part��dirty state, saving, commit, focus, selection
		 * changes�ȵ��������¼���
		 * �����Ǳ����е�ÿһ��-�ռ�վ����Ҫ��Ϊһ��IFormPart����ý�һ��controlͨ��ʵ��IFormPart���һ�
		 * �Part. һ����˵Section����һ����Ȼ�γɵ��飬����Eclipse Form�ṩ��һ��SectionPart��ʵ�֣�
		 * ������һ��Section�Ķ���
		 */
		final SectionPart spart = new SectionPart(section);
		// ע��ö���IManagedForm������������
		managedForm.addPart(spart);
		// ����ͨ������װ��MVC����
		TreeViewer viewer = new TreeViewer(tree);
		// ע������ѡ���¼�������
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			// ����������ĳһ���ڵ�ʱ
			public void selectionChanged(SelectionChangedEvent event) {
				// ͨ��IManagedForm������IFormPart����Ӧ���¼�
				managedForm.fireSelectionChanged(spart, event.getSelection());
			}
		});
		// ������������
		viewer.setContentProvider(new MasterContentProvider());
		// �������ı�ǩ
		viewer.setLabelProvider(new MasterLabelProvider());
		// ���ó�ʼ���������
		viewer.setInput(new File("E:\\Program Files"));
	}

	// ע����ϸҳ�沿��
	protected void registerPages(DetailsPart detailsPart) {
		// ��DirectoryDetailPage����ע��
		detailsPart.registerPage(File.class, new DirectoryDetailPage());
	}

	// ������������Action
	protected void createToolBarActions(IManagedForm managedForm) {
		final ScrolledForm form = managedForm.getForm();
		// ˮƽ���ֲ���
		Action hAction = new Action("horizon", Action.AS_RADIO_BUTTON) {
			public void run() {
				sashForm.setOrientation(SWT.HORIZONTAL);
				form.reflow(true);
			}
		};
		hAction.setChecked(true);
		hAction.setToolTipText("ˮƽ����");
		hAction.setImageDescriptor(MyRCPActivator.getImageDescriptorFromPlugin("icons/hor.gif"));
		// ��ֱ���ֲ���
		Action vAction = new Action("vertical", Action.AS_RADIO_BUTTON) {
			public void run() {
				sashForm.setOrientation(SWT.VERTICAL);
				form.reflow(true);
			}
		};
		vAction.setChecked(false);
		vAction.setToolTipText("��ֱ����"); //$NON-NLS-1$
		vAction.setImageDescriptor(MyRCPActivator.getImageDescriptorFromPlugin("icons/ver.gif"));
		// ���������������ӵ������Ĺ�������������
		form.getToolBarManager().add(hAction);
		form.getToolBarManager().add(vAction);
	}

	public class MasterContentProvider implements ITreeContentProvider {

		public Object[] getChildren(Object element) {
			return ((File) element).listFiles();
		}

		public Object[] getElements(Object element) {
			return ((File) element).listFiles();
		}

		public boolean hasChildren(Object element) {
			Object[] obj = getChildren(element);
			return obj == null ? false : obj.length > 0;
		}

		public Object getParent(Object element) {
			return ((File) element).getParentFile();
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

	}

	class MasterLabelProvider implements ILabelProvider {

		public Image getImage(Object element) {
			File file = (File) element;
			if (file.isDirectory())
				return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
			else
				return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
		}

		public String getText(Object element) {
			String text = ((File) element).getName();
			if (text.length() == 0) {
				text = ((File) element).getPath();
			}
			return text;
		}

		public void addListener(ILabelProviderListener listener) {
		}

		public void dispose() {

		}

		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		public void removeListener(ILabelProviderListener listener) {
		}

	}

}
