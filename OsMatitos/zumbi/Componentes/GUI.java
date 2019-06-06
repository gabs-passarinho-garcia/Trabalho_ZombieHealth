package zumbi.Componentes;

import zumbi.Interfaces.IGUI.IGUI;
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

public class GUI implements IGUI{

	protected Shell shell;
	
	private int diag = 0;
	private Text textMedico;
	private Text textPaciente;
	
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
			GUI window = new GUI();
			window.open();
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
		shell.setText("SWT Application");
		
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
		btnDiagnostico.setAlignment(SWT.RIGHT);
		btnDiagnostico.setBounds(411, 215, 79, 29);
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
		
		Label lblBackground = new Label(shell, SWT.NONE);
		lblBackground.setImage(SWTResourceManager.getImage("./Imagens/hospital_room.png"));
		lblBackground.setBounds(0, 0, 900, 472);
		shell.setTabList(new Control[]{textMedico, textPaciente, btnDiagnostico, btnMedico, btnPaciente});

	}
}
