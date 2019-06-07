package zumbi.Componentes;

import zumbi.Interfaces.IGUI.IGUI;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.FileDialog;

public class GUI implements IGUI{

	protected Shell shell;
	
	private int diag = 0;
	private Text textMedico;
	private Text textPaciente;
	static Boolean reset_button = true;
	
	public void openDiag(Button atual) {
		if(diag>1)
			atual.setVisible(true);
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			while(reset_button == true) {
				reset_button = false;
				GUI window = new GUI();
				window.open();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(890, 500);
		shell.setText("Matitos's Hospital");
		
		Button btnMedico = new Button(shell, SWT.NONE);
		Button btnPaciente = new Button(shell, SWT.NONE);
		Label lblMedico = new Label(shell, SWT.NONE);
		Label lblPaciente = new Label(shell, SWT.NONE);
		Button btnDiagnostico = new Button(shell, SWT.NONE);
		Label lblNomeMedico = new Label(shell, SWT.NONE);
		Label lblNomePaciente = new Label(shell, SWT.NONE);
		textMedico = new Text(shell, SWT.BORDER);
		textPaciente = new Text(shell, SWT.BORDER);
		Label lblNomeM = new Label(shell, SWT.NONE);
		lblNomeM.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		Label lblNomeP = new Label(shell, SWT.NONE);
		lblNomeP.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		StyledText Diagnostico = new StyledText(shell, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		Button btnSalvar = new Button(shell, SWT.NONE);
		Button btnMotivar = new Button(shell, SWT.NONE);
		Button btnEstatisticas = new Button(shell, SWT.NONE);
		Button btnResetar = new Button(shell, SWT.NONE);
		
		//Label lblNomeM = new Label(shell, SWT.NONE);
		lblNomeM.setBounds(53, 359, 363, 17);
		
		//Button btnMedico = new Button(shell, SWT.NONE);
		btnMedico.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnMedico.setVisible(false);
				lblNomeMedico.setVisible(false);
				textMedico.setVisible(false);
				lblMedico.setVisible(true);
				lblNomeM.setText(textMedico.getText() + " , o Médico Penguim.");
				diag++;
				openDiag(btnDiagnostico);
			}
		});
		btnMedico.setBounds(78, 250, 159, 29);
		btnMedico.setText("Generate Doctor");
		
		//Button btnPaciente = new Button(shell, SWT.NONE);
		btnPaciente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnPaciente.setVisible(false);
				lblNomePaciente.setVisible(false);
				textPaciente.setVisible(false);
				lblPaciente.setVisible(true);
				lblNomeP.setText(textPaciente.getText() + " , o Paciente Zumbi.");
				diag++;
				openDiag(btnDiagnostico);
			}
		});
		btnPaciente.setBounds(658, 250, 150, 29);
		btnPaciente.setText("Generate Patient");
		
		//Label lblMedico = new Label(shell, SWT.NONE);
		lblMedico.setImage(SWTResourceManager.getImage("./Imagens/penguin_doctor.png"));
		lblMedico.setBounds(53, 80, 200, 300);
		lblMedico.setVisible(false);
		
		//Label lblPaciente = new Label(shell, SWT.NONE);
		lblPaciente.setImage(SWTResourceManager.getImage("./Imagens/patient.png"));
		lblPaciente.setBounds(608, 64, 200, 300);
		lblPaciente.setVisible(false);
		
		//Button btnDiagnostico = new Button(shell, SWT.NONE);
		btnDiagnostico.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Diagnostico.setText("Diagnóstico:\n");
				btnDiagnostico.setVisible(false);
				Diagnostico.setVisible(true);
				btnSalvar.setVisible(true);
				btnMotivar.setVisible(true);
				btnEstatisticas.setVisible(true);
				btnResetar.setVisible(true);
			}
		});
		btnDiagnostico.setAlignment(SWT.RIGHT);
		btnDiagnostico.setBounds(382, 215, 79, 29);
		btnDiagnostico.setText("Diagnose");
		btnDiagnostico.setVisible(false);
		
		//textMedico = new Text(shell, SWT.BORDER);
		textMedico.setBounds(78, 215, 159, 29);
		
		//textPaciente = new Text(shell, SWT.BORDER);
		textPaciente.setBounds(658, 215, 150, 29);
		
		//Label lblNomeMedico = new Label(shell, SWT.NONE);
		lblNomeMedico.setAlignment(SWT.CENTER);
		lblNomeMedico.setBounds(78, 192, 159, 17);
		lblNomeMedico.setText("Nome do Médico:");
		
		//Label lblNomePaciente = new Label(shell, SWT.NONE);
		lblNomePaciente.setAlignment(SWT.CENTER);
		lblNomePaciente.setBounds(658, 192, 150, 17);
		lblNomePaciente.setText("Nome do Paciente:");
		
		//Label lblNomeP = new Label(shell, SWT.NONE);
		lblNomeP.setBounds(608, 359, 251, 48);
		
		//StyledText Diagnostico = new StyledText(shell, SWT.BORDER);
		Diagnostico.setBounds(307, 80, 226, 118);
		Diagnostico.setVisible(false);
		
		//Button btnSalvar = new Button(shell, SWT.NONE);
		btnSalvar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fld = new FileDialog(shell, SWT.SAVE);
				fld.setText("Salvar Diagnóstico");
				String txtFilter[] = {".txt"};
				fld.setFilterExtensions(txtFilter);
				fld.setFileName("diagnostico");
				fld.setFilterPath("");
				fld.open();
				try {
					FileWriter arquivo = new FileWriter(fld.getFileName());
					PrintWriter formatado = new PrintWriter(arquivo);
					formatado.println(Diagnostico.getText());
					arquivo.close();
				} catch(IOException erro) {
					erro.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(307, 215, 97, 29);
		btnSalvar.setText("Salvar");
		btnSalvar.setVisible(false);
		
		//Button btnMotivar = new Button(shell, SWT.NONE);
		btnMotivar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnMotivar.setBounds(436, 215, 97, 29);
		btnMotivar.setText("Motivar");
		btnMotivar.setVisible(false);
		
		//Button btnEstatisticas = new Button(shell, SWT.NONE);
		btnEstatisticas.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnEstatisticas.setBounds(307, 250, 97, 29);
		btnEstatisticas.setText("Estatísticas");
		btnEstatisticas.setVisible(false);
		
		//Button btnResetar = new Button(shell, SWT.NONE);
		btnResetar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				reset_button = true;
				shell.close();
			}
		});
		btnResetar.setBounds(436, 250, 97, 29);
		btnResetar.setText("Resetar");
		btnResetar.setVisible(false);
		
		Label lblBackground = new Label(shell, SWT.NONE);
		lblBackground.setImage(SWTResourceManager.getImage("./Imagens/hospital_room.png"));
		lblBackground.setBounds(0, 0, 900, 472);
		shell.setTabList(new Control[]{textMedico, textPaciente, btnDiagnostico, btnMedico, btnPaciente});

	}
}
