package com.xiong.myrcp01.views;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.HyperlinkGroup;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.ui.part.ViewPart;

import com.xiong.myrcp01.main.MyRCPActivator;

public class MyFormView extends ViewPart {

	public static final String ID = "com.xiong.myrcp01.views.MyFormView";

	private FormToolkit toolkit;

	private ScrolledForm form;

	public MyFormView() {
		super();
	}

	public void createPartControl(Composite parent) {
		toolkit = new FormToolkit(parent.getDisplay());
		form = toolkit.createScrolledForm(parent);
		form.setText("Hello, Eclipse ����");

		form.getBody().setLayout(new TableWrapLayout());

		ExpandableComposite expcomp = toolkit.createExpandableComposite(form.getBody(), ExpandableComposite.TREE_NODE);
		String txt = "��Web��ҳ��UI��ϵ�У������Ҳ��Ч����õľ���ʹҳ���еĲ��������е����ݿ����۵���չ����Eclipse����Ҳ�ṩ�˿��۵�����壨ExpandableComposite����ʵ����ͬ�Ĺ���.";
		Label client = toolkit.createLabel(expcomp, txt, SWT.WRAP);
		expcomp.setText("����һ�����۵�����壨ExpandableComposite��");
		expcomp.setClient(client);
		expcomp.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(true);
			}
		});

		Section section = toolkit.createSection(form.getBody(),
				Section.TWISTIE | Section.TITLE_BAR | Section.DESCRIPTION);
		section.setText("����һ��������(Section)");
		Composite sectionClient = toolkit.createComposite(section);
		sectionClient.setLayout(new GridLayout());
		Button bt1 = toolkit.createButton(sectionClient, "CheckBox 1", SWT.CHECK);
		Button bt2 = toolkit.createButton(sectionClient, "CheckBox 2", SWT.CHECK);
		section.setClient(sectionClient);
		toolkit.createCompositeSeparator(section);
		section.setDescription("�����ڱ������µ�һ������");
		section.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(true);
			}
		});
		// ������ͼ��ĳ�����
		ImageHyperlink imageHyperlink = toolkit.createImageHyperlink(section, SWT.CENTER);
		// ���ó����ӵ�ͼ��
		imageHyperlink.setImage(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD).createImage());
		// ����ͼ�곬�������ӵ��������Ĺ�������
		section.setTextClient(imageHyperlink);

		// ����һ��������
		Section linkSection = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.TITLE_BAR);
		linkSection.setText("���ǳ�������");
		Composite linkComp = toolkit.createComposite(linkSection);
		linkComp.setLayout(new GridLayout());
		linkSection.setClient(linkComp);
		// ���������ӣ����ֿ���������ʾ
		Hyperlink textLink = toolkit.createHyperlink(linkComp, "����һ���ı�������", SWT.WRAP);
		// ע�ᳬ�����¼�������
		textLink.addHyperlinkListener(new IHyperlinkListener() {
			public void linkEntered(HyperlinkEvent e) {
				// �����볬��������
			}

			public void linkExited(HyperlinkEvent e) {
				// ����뿪����������
			}

			public void linkActivated(HyperlinkEvent e) {
				// ���������Ӽ���ʱ
				System.out.println("�����ӱ�����");
			}

		});
		// ��������ͼƬ�ĳ�����
		ImageHyperlink imageLink = toolkit.createImageHyperlink(linkComp, SWT.WRAP);
		// ���ó����ӵ�ͼ��

		imageLink.setImage(MyRCPActivator.getImageDescriptorFromPlugin("icons/help_contents.gif").createImage());
		// ���ó����ӵ��ı�
		imageLink.setText("����һ��ͼƬ������");

		imageLink.setHoverImage(MyRCPActivator.getImageDescriptorFromPlugin("icons/linkto_help.gif").createImage());
		// ע�ᳬ���Ӽ�������ʹ��HyperlinkAdapter����������
		imageLink.addHyperlinkListener(new HyperlinkAdapter() {
			public void linkActivated(HyperlinkEvent e) {
				System.out.println("�����ӱ�����");
			}
		});
		linkSection.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				// ���ݿؼ����³ߴ����¶�λ�͸��¹�����
				form.reflow(true);
			}
		});

		// ����һ���������Ķ���true��ʾ���ñ�����ý���ʱ�����������ӵĽ�������Ϊ�ɼ�
		FormText formText = toolkit.createFormText(form.getBody(), false);
		// ����һ���ַ��������а���http://��ʽ���ַ�
		// String text = "�����޸�ʽ���ı�"+"���Ǵ��г����ӵ��ı� http://www.eclipse.org
		// ���Զ�ת��Ϊ������,<a> http://www.eclipse.org</a>";
		// �����ı�false��ʾ��ת��tag��ǣ�true��ʾת��������
		// formText.setText(text, true, false);
		// ע�ᵥ������������
		formText.addHyperlinkListener(new HyperlinkAdapter() {
			// ����������ʱ
			public void linkActivated(HyperlinkEvent e) {
				// ��ӡ�������ĳ����ӵ�ַ
				System.out.println("�����˸ó����ӣ�" + e.getHref());
			}
		});
		// �����ı�����Ҫʹ��ͼƬ��ʹ�õ�һ����ΪͼƬ��key����ֵ�ɱ�xml����е�<img>����е�href����
		formText.setImage("image1", MyRCPActivator.getImageDescriptorFromPlugin("icons/samples.gif").createImage());
		// �����ı�������Ҫʹ�õ����壬��һ��������ʾ�����key��ֵ�ɱ�<span>��font��������
		formText.setFont("head", form.getFont());
		// �����ı�������Ҫʹ�õ���ɫ����һ��������ʾ��ɫ��key��ֵ�ɱ�<span>��color��������
		formText.setColor("headColor", form.getForeground());
		// �����ı��������õĿؼ�,��һ��������ʾ�ؼ���key��ֵ�ɱ�<control>��href��������
		formText.setControl("myControl", toolkit.createButton(form.getBody(), "����һ����ť", SWT.NONE));
		// װ�ظ���MyFormView.javaͬ�ļ����µ�demo.xml�ļ�
		InputStream is = MyFormView.class.getResourceAsStream("demo.xml"); //$NON-NLS-1$
		if (is != null) {// �����ڸ��ļ�
			formText.setContents(is, true);
			try {
				// ���ر�������
				is.close();
			} catch (IOException e) {
			}
		}
		HyperlinkGroup group = toolkit.getHyperlinkGroup();
	}

	public void setFocus() {
		form.setFocus();
	}

	public void dispose() {
		toolkit.dispose();
		super.dispose();
	}
}
