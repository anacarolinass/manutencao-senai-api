package br.com.senai.manutencaosenaiapi.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.manutencaosenaiapi.entity.Peca;
import br.com.senai.manutencaosenaiapi.service.PecaService;
import javax.swing.JTextArea;
import java.awt.Color;

@Component
public class TelaCadastrodePeca extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtId;
	private JTextField txtDescricao;
	private JLabel lblEspecificacoes;
	private JTextArea jtaEspecificacoes;

	@Autowired
	private PecaService service;
	private JTextField edtQtd;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaCadastrodePeca() {
		setTitle("Cadastro de Tipo de Peça");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 280);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblId = new JLabel("ID");

		edtId = new JTextField();
		edtId.setEnabled(false);
		edtId.setColumns(10);

		JLabel lblDescrição = new JLabel("Descrição");

		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					if (edtId.getText() != null && edtId.getText().length() > 0) {
						Peca pecaSalva = new Peca();
						//pecaSalva.setDescricao(txtDescricao.getText)
					pecaSalva.setQtdeEmEstoque(Integer.parseInt(edtQtd.getText()));
					pecaSalva.setEspecificacoes(jtaEspecificacoes.getText());
					pecaSalva.setId(Integer.parseInt(edtId.getText()));
					service.alterar(pecaSalva);
					
						

					} else {
						Peca novaPeca = new Peca();
						novaPeca.setDescricao(lblDescrição.getText());
						novaPeca.setQtdeEmEstoque(Integer.parseInt(edtQtd.getText()));

						novaPeca.setEspecificacoes(jtaEspecificacoes.getText());
						Peca pecaSalva = service.inserir(novaPeca);
						edtId.setText(pecaSalva.getId().toString());
						JOptionPane.showMessageDialog(contentPane,"Peça inserida com sucesso");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(contentPane, e2.getMessage());
				}

			}
		});

		JLabel lblQtde = new JLabel("QtdE");

		edtQtd = new JTextField();
		edtQtd.setColumns(10);

		lblEspecificacoes = new JLabel("Especificações");

		jtaEspecificacoes = new JTextArea();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
										.createSequentialGroup()
										.addGroup(gl_contentPane
												.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 41,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(edtId, GroupLayout.PREFERRED_SIZE, 43,
														GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblDescrição)
														.addPreferredGap(ComponentPlacement.RELATED, 301,
																Short.MAX_VALUE)
														.addComponent(lblQtde).addGap(89))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE, 328,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED, 21,
																Short.MAX_VALUE)
														.addComponent(edtQtd, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addContainerGap())))
								.addComponent(btnSalvar, Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblEspecificacoes)
										.addContainerGap(481, Short.MAX_VALUE))
								.addGroup(gl_contentPane
										.createSequentialGroup().addComponent(jtaEspecificacoes,
												GroupLayout.PREFERRED_SIZE, 497, GroupLayout.PREFERRED_SIZE)
										.addContainerGap()))));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblDescrição).addComponent(lblId).addComponent(lblQtde))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(edtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(edtQtd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblEspecificacoes)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(jtaEspecificacoes, GroupLayout.PREFERRED_SIZE, 111,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
								.addComponent(btnSalvar)));
		contentPane.setLayout(gl_contentPane);
	}

	public void colocarEmEdicao(Peca pecaSalva) {
		edtId.setText(pecaSalva.getId().toString());
		txtDescricao.setText(pecaSalva.getDescricao());
		jtaEspecificacoes.setText(pecaSalva.getEspecificacoes());
		edtQtd.setText(pecaSalva.getQtdeEmEstoque().toString());
	}
}
