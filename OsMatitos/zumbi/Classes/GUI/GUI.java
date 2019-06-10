package zumbi.Classes.GUI;

import jsmaiorjava.implementations.ImprimeAtestado;
import jsmaiorjava.interfaces.IImprimeAtestado;

import speak.Speak;
import jsmaiorjava.implementations.Prontuario;
import jsmaiorjava.implementations.Tratamento;
import jsmaiorjava.implementations.ZumbiTwittero;
import jsmaiorjava.interfaces.IProntuario;
import jsmaiorjava.interfaces.ITratamento;
import jsmaiorjava.interfaces.IZumbiTwittero;
import jsmaiorjava.implementations.ImprimeAtestado;
import jsmaiorjava.interfaces.IImprimeAtestado;

import zumbi.Interfaces.IGUI.IGUI;
import org.eclipse.swt.widgets.MessageBox;
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
import javax.swing.JDesktopPane;
import javax.swing.JLabel;

import zumbi.Classes.ContaSuperFactory.*;
import zumbi.Classes.ConversorString.*;
import zumbi.Classes.GUI.*;
import zumbi.Classes.MelhorFactory.*;
import zumbi.Componentes.DataSetComponent.*;
import zumbi.Componentes.RedutorPossibilidades.*;
import zumbi.Componentes.Supervisor.*;
import zumbi.Consulta.Pessoas.*;
import zumbi.Interfaces.IContador.*;
import zumbi.Interfaces.IContaFactory.*;
import zumbi.Interfaces.IDataSet.*;
import zumbi.Interfaces.IDoctor.*;
import zumbi.Interfaces.IGUI.*;
import zumbi.Interfaces.IPatient.*;
import zumbi.Interfaces.IRedutorPossibilidades.*;
import zumbi.Interfaces.ISupervisor.*;

public class GUI implements IGUI{

	protected Shell shell;
	
	private int diag = 0;
	private Text textMedico;
	private Text textPaciente;
	private String csv = "";
	static Boolean reset_button = true;
	
	private IDoctor doutor;
	private IPatient paciente;
	private IDataSet dataset = new DataSetComponent();
	private ISupervisor supervisor =  FabricaSupervisor.criarSupervisor();
	
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
	 * @wbp.parser.entryPoint
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
		
		Button btnImportarCSV = new Button(shell, SWT.NONE);
		Button btnIniciar = new Button(shell, SWT.NONE);
		Button btnIniciarFalso = new Button(shell, SWT.NONE);
		btnIniciarFalso.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		btnIniciarFalso.setBounds(370, 260, 124, 29);
		btnIniciarFalso.setText("Iniciar");
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
		Button btnNovoPaciente = new Button(shell, SWT.NONE);
		Button btnAtestado = new Button(shell, SWT.NONE);
		Button btnTwittar = new Button(shell, SWT.NONE);
		
		//Button btnImportarCSV = new Button(shell, SWT.NONE);
		btnImportarCSV.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fld = new FileDialog(shell, SWT.OPEN);
				fld.setText("Importar CSV");
				String txtFilter[] = {".csv"};
				fld.setFilterNames(txtFilter);
				fld.setFilterPath("");
				fld.open();
				if(fld.getFilterPath().equals("")) {
					return;
				}
				else if(fld.getFileName().indexOf(".csv")==-1) {
					return;
				}
				else {
					csv = fld.getFilterPath() + "/" + fld.getFileName();
					dataset.setDataSource(csv);
					System.out.println(csv);
					btnIniciarFalso.setVisible(false);
					btnIniciar.setVisible(true);
					
					//System.out.println(dataset.requestInstances()[0][0]);
					
				}
			}
		});
		btnImportarCSV.setBounds(370, 215, 124, 29);
		btnImportarCSV.setText("Importar CSV");
		
		btnIniciar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblNomeMedico.setVisible(true);
				textMedico.setVisible(true);
				btnMedico.setVisible(true);
				
				lblNomePaciente.setVisible(true);
				textPaciente.setVisible(true);
				btnPaciente.setVisible(true);
				
				btnImportarCSV.setVisible(false);
				btnIniciar.setVisible(false);
			}
		});
		btnIniciar.setBounds(370, 260, 124, 29);
		btnIniciar.setText("Iniciar");
		btnIniciar.setVisible(false);
		
		btnIniciarFalso.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		btnIniciarFalso.setBounds(370, 260, 124, 29);
		btnIniciarFalso.setText("Iniciar");
		
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
				
				doutor = new Doctor();
				doutor.connect(dataset);
				
			}
		});
		btnMedico.setBounds(78, 250, 159, 29);
		btnMedico.setText("Gerar Doutor");
		btnMedico.setVisible(false);
		
		//Button btnPaciente = new Button(shell, SWT.NONE);
		btnPaciente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnPaciente.setVisible(false);
				lblNomePaciente.setVisible(false);
				textPaciente.setVisible(false);
				lblPaciente.setVisible(true);
				lblNomeP.setText(textPaciente.getText() + " , o Paciente Zumbi.");
				lblNomeP.setVisible(true);
				diag++;
				openDiag(btnDiagnostico);
				
				
				paciente = new Patient();
				paciente.connect(dataset);
				
			}
		});
		btnPaciente.setBounds(658, 250, 150, 29);
		btnPaciente.setText("Generate Paciente");
		btnPaciente.setVisible(false);
		
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
				btnNovoPaciente.setVisible(true);
				btnAtestado.setVisible(true);
				btnTwittar.setVisible(true);
				
				doutor.connect(paciente);
				paciente.connect(supervisor);
				
				doutor.startInterview();
				Diagnostico.setText("Diagnóstico:\n " + doutor.getDiagnose());
				Speak.speak(textPaciente.getText() + " tem a doença" + doutor.getDiagnose());
				
			}
		});
		btnDiagnostico.setBounds(381, 215, 109, 29);
		btnDiagnostico.setText("Diagnóstico");
		btnDiagnostico.setVisible(false);
		
		//textMedico = new Text(shell, SWT.BORDER);
		textMedico.setBounds(78, 215, 159, 29);
		textMedico.setVisible(false);
		
		//textPaciente = new Text(shell, SWT.BORDER);
		textPaciente.setBounds(658, 215, 150, 29);
		textPaciente.setVisible(false);
		
		//Label lblNomeMedico = new Label(shell, SWT.NONE);
		lblNomeMedico.setAlignment(SWT.CENTER);
		lblNomeMedico.setBounds(78, 192, 159, 17);
		lblNomeMedico.setText("Nome do Médico:");
		lblNomeMedico.setVisible(false);
		
		//Label lblNomePaciente = new Label(shell, SWT.NONE);
		lblNomePaciente.setAlignment(SWT.CENTER);
		lblNomePaciente.setBounds(658, 192, 150, 17);
		lblNomePaciente.setText("Nome do Paciente:");
		lblNomePaciente.setVisible(false);
		
		//Label lblNomeP = new Label(shell, SWT.NONE);
		lblNomeP.setBounds(608, 359, 251, 48);
		
		//StyledText Diagnostico = new StyledText(shell, SWT.BORDER);
		Diagnostico.setBounds(307, 80, 242, 118);
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
		btnSalvar.setBounds(307, 215, 109, 29);
		btnSalvar.setText("Salvar");
		btnSalvar.setVisible(false);
		
		//Button btnMotivar = new Button(shell, SWT.NONE);
		btnMotivar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageBox stat = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.OK);
				String message = supervisor.strMotivar();
				stat.setText("Motivação");
				stat.setMessage(message);
				stat.open();
			}
		});
		btnMotivar.setBounds(436, 215, 113, 29);
		btnMotivar.setText("Motivar");
		btnMotivar.setVisible(false);
		
		//Button btnEstatisticas = new Button(shell, SWT.NONE);
		btnEstatisticas.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageBox stat = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.OK);
				stat.setText("Estatísticas");
				stat.setMessage(supervisor.strRelatorio());
				stat.open();
				
				System.out.println(supervisor.strRelatorio());
			}
		});
		btnEstatisticas.setBounds(307, 250, 109, 29);
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
		btnResetar.setBounds(307, 285, 109, 29);
		btnResetar.setText("Resetar");
		btnResetar.setVisible(false);
		
		//Button btnNovoPaciente = new Button(shell, SWT.NONE);
		btnNovoPaciente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
					btnDiagnostico.setVisible(false);
					Diagnostico.setVisible(false);
					btnSalvar.setVisible(false);
					btnMotivar.setVisible(false);
					btnEstatisticas.setVisible(false);
					btnResetar.setVisible(false);
					btnNovoPaciente.setVisible(false);
					
					btnPaciente.setVisible(true);
					lblNomePaciente.setVisible(true);
					textPaciente.setVisible(true);
					lblPaciente.setVisible(false);
					lblNomeP.setVisible(false);
					btnAtestado.setVisible(false);
					btnTwittar.setVisible(false);
					diag--;
					openDiag(btnDiagnostico);
			}
		});
		btnNovoPaciente.setBounds(436, 250, 113, 29);
		btnNovoPaciente.setText("Novo Paciente");
		btnNovoPaciente.setVisible(false);
		
		//Button btnAtestado = new Button(shell, SWT.NONE);
		btnAtestado.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				IImprimeAtestado escriba = new ImprimeAtestado();
				IProntuario prontuario = new Prontuario(textPaciente.getText(), textMedico.getText(), doutor.getDiagnose());
				escriba.imprime(prontuario);
			}
		});
		btnAtestado.setBounds(436, 285, 113, 29);
		btnAtestado.setText("Atestado");
		btnAtestado.setVisible(false);
		
		//Button btnTwittar = new Button(shell, SWT.NONE);
		btnTwittar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
		            String doenca = doutor.getDiagnose();
		            ITratamento tratamento = new Tratamento(doenca);
		            String paciente = textPaciente.getText();
		            String doutor = textMedico.getText();
		            IProntuario prontuario = new Prontuario(tratamento, paciente, doutor);
		            ZumbiTwittero zt = new ZumbiTwittero(prontuario,
		                    "CHU CHU, LÁ VEM O TREM DAS DOENÇAS:\n" +
		                     "@doutor examinando @paciente, que aparentemente tem @doenca.\n" +
		                            "O tratamento consiste em: @tratamento.");

		            boolean sucesso = zt.twittar();

		            if (sucesso)
		                System.out.println("Deu bom");

		            else
		                System.out.println("Deu ruim");

		        } catch (Exception a) {
		            System.out.println(a);
		        }
			}
		});
		btnTwittar.setBounds(307, 320, 109, 29);
		btnTwittar.setText("Twittar");
		btnTwittar.setVisible(false);
		
		Label lblBackground = new Label(shell, SWT.NONE);
		lblBackground.setImage(SWTResourceManager.getImage("./Imagens/hospital_room.png"));
		lblBackground.setBounds(0, 0, 900, 472);
		shell.setTabList(new Control[]{textMedico, textPaciente, btnDiagnostico, btnMedico, btnPaciente});

	}
}
