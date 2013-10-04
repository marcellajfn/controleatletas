package controleatleta;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class CadastroArqueiro extends javax.swing.JFrame {

    private final byte SEXO_MASCULINO_INDICE = 0;
    private final byte SEXO_FEMININO_INDICE = 1;
    private final char SEXO_MASCULINO_VALOR = 'M';
    private final char SEXO_FEMININO_VALOR = 'F';
    private final byte TIPOARCO_TRADICIONAL_INDICE = 0;
    private final byte TIPOARCO_RECURVO_INDICE = 1;
    private final byte TIPOARCO_COMPOSTO_INDICE = 2;
    private final char TIPOARCO_TRADICIONAL_VALOR = 'T';
    private final char TIPOARCO_RECURVO_VALOR = 'R';
    private final char TIPOARCO_COMPOSTO_VALOR = 'C';    
    private final byte MODALIDADE_OUTDOOR_INDICE = 0;
    private final byte MODALIDADE_INDOOR_INDICE = 1;
    private final byte MODALIDADE_FIELD_INDICE = 2;
    private final byte MODALIDADE_SKIARCHERY_INDICE = 3;
    private final byte MODALIDADE_CLOUT_INDICE = 4;
    private final byte MODALIDADE_FLIGHT_INDICE = 5;
    private final char MODALIDADE_OUTDOOR_VALOR = 'O';
    private final char MODALIDADE_INDOOR_VALOR = 'I';
    private final char MODALIDADE_FIELD_VALOR = 'F';
    private final char MODALIDADE_SKIARCHERY_VALOR = 'S';
    private final char MODALIDADE_CLOUT_VALOR = 'C';
    private final char MODALIDADE_FLIGHT_VALOR = 'L';
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private ControleArqueiro controleArqueiro;
    private Arqueiro umArqueiro;
    private boolean modoAlteracao;
    private boolean novoRegistro;
    private DefaultListModel telefonesListModel;
    private DefaultListModel premiacaoListModel;

    public CadastroArqueiro() {
        initComponents();
        this.habilitarDesabilitarCampos();
        this.controleArqueiro = new ControleArqueiro();
        this.telefonesListModel = new DefaultListModel();
        this.jListTelefones.setModel(telefonesListModel);
        this.premiacaoListModel = new DefaultListModel();
        this.jListPremiacoes.setModel(premiacaoListModel);
        this.jTableListaArqueiros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void limparCampos() {
        jTextFieldAltura.setText("0.0");
        jTextFieldBairro.setText(null);
        jTextFieldAlvo.setText(null);
        jTextFieldTipoCompetidor.setText(null);
        jTextFieldCep.setText(null);
        jTextFieldCidade.setText(null);
        jTextFieldComplemento.setText(null);
        jTextFieldCpf.setText(null);
        jTextFieldDataNascimento.setText(null);
        jTextFieldDistancia.setText("0");
        jComboBoxEstado.setSelectedIndex(0);
        jTextFieldLogradouro.setText(null);
        jTextFieldNome.setText(null);
        jTextFieldNomeMae.setText(null);
        jTextFieldNomePai.setText(null);
        jTextIdade.setText("0");
        jTextFieldNumero.setText("0");
        jTextFieldPais.setText(null);
        jTextFieldPeso.setText("0.0");
        jTextFieldRg.setText(null);
        jTextFieldTotalDeMedalhas.setText("0");
        jTextFieldTotalDesistencias.setText("0");
        jTextFieldAcertosNaMosca.setText("0");
        jTextFieldTamanhoDoArco.setText("0.0");
        jTextFieldTipoDeFlecha.setText(null);
        telefonesListModel.clear();
        premiacaoListModel.clear();
        jComboBoxSexo.setSelectedIndex(0);
        jComboModalidade.setSelectedIndex(0);
        jComboTipoDeArco.setSelectedIndex(0);
        this.atualizarTipoCompetidor();
    }

    private void preencherCampos() {
        ArrayList<String> telefones;
        ArrayList<Premiacao> premiacoes;

        jTextFieldAltura.setText(Double.toString(umArqueiro.getAltura()));
        jTextFieldBairro.setText(umArqueiro.getEndereco().getBairro());
        jTextFieldTipoCompetidor.setText(Character.toString(umArqueiro.getSexo())); 
        jTextFieldCep.setText(umArqueiro.getEndereco().getCep());
        jTextFieldCidade.setText(umArqueiro.getEndereco().getCidade());
        jTextFieldComplemento.setText(umArqueiro.getEndereco().getComplemento());
        jTextFieldCpf.setText(umArqueiro.getCpf());
        if (umArqueiro.getDataNascimento() == null) {
            jTextFieldDataNascimento.setText(null);
        } else {
            jTextFieldDataNascimento.setText(dateFormat.format(umArqueiro.getDataNascimento()));
        }
        jTextFieldDistancia.setText(Double.toString(umArqueiro.getDistancia()));
        jComboBoxEstado.setSelectedItem(umArqueiro.getEndereco().getEstado());
        jTextFieldLogradouro.setText(umArqueiro.getEndereco().getLogradouro());
        jTextFieldNome.setText(umArqueiro.getNome());
        jTextIdade.setText(Double.toString(umArqueiro.getIdade()));
        jTextFieldNomeMae.setText(umArqueiro.getNomeMae());
        jTextFieldNomePai.setText(umArqueiro.getNomePai());
        jTextFieldNumero.setText(umArqueiro.getEndereco().getNumero().toString());
        jTextFieldPais.setText(umArqueiro.getEndereco().getPais());
        jTextFieldPeso.setText(Double.toString(umArqueiro.getPeso()));
        jTextFieldRg.setText(umArqueiro.getRg());
        jTextFieldTotalDeMedalhas.setText(Integer.toString(umArqueiro.getTotalMedalhas()));
        jTextFieldTotalDesistencias.setText(Integer.toString(umArqueiro.getTotalDesistencias()));
        jTextFieldAcertosNaMosca.setText(Integer.toString(umArqueiro.getTotalAcertosNaMosca()));
        jTextFieldTamanhoDoArco.setText(Double.toString(umArqueiro.getTamanhoArco()));
        jTextFieldAlvo.setText((umArqueiro.getAlvo()));
        jTextFieldTipoDeFlecha.setText((umArqueiro.getTipoFlecha()));

        telefonesListModel.clear();
        telefones = umArqueiro.getTelefones();
        for (String t : telefones) {
            telefonesListModel.addElement(t);
        }

        premiacaoListModel.clear();
        premiacoes = umArqueiro.getPremiacoes();
        for (Premiacao p : premiacoes) {
            premiacaoListModel.addElement(p);
        }

        switch (umArqueiro.getSexo()) {
            case SEXO_MASCULINO_VALOR:
                jComboBoxSexo.setSelectedIndex(SEXO_MASCULINO_INDICE);
                break;
            case SEXO_FEMININO_VALOR:
                jComboBoxSexo.setSelectedIndex(SEXO_FEMININO_INDICE);
                break;
        }

        switch (umArqueiro.getModalidade()) {
            case MODALIDADE_OUTDOOR_VALOR:
                jComboModalidade.setSelectedIndex(MODALIDADE_OUTDOOR_INDICE);
                break;
            case MODALIDADE_INDOOR_VALOR:
                jComboModalidade.setSelectedIndex(MODALIDADE_INDOOR_INDICE);
                break;
            case MODALIDADE_FIELD_VALOR:
                jComboModalidade.setSelectedIndex(MODALIDADE_FIELD_INDICE);
                break;
            case MODALIDADE_SKIARCHERY_VALOR:
                jComboModalidade.setSelectedIndex(MODALIDADE_SKIARCHERY_INDICE);
                break;
            case MODALIDADE_CLOUT_VALOR:
                jComboModalidade.setSelectedIndex(MODALIDADE_CLOUT_INDICE);
                break;
            case MODALIDADE_FLIGHT_VALOR:
                jComboModalidade.setSelectedIndex(MODALIDADE_FLIGHT_INDICE);
                break;
        }

        switch (umArqueiro.getTipoArco()) {
            case TIPOARCO_TRADICIONAL_VALOR:
                jComboTipoDeArco.setSelectedIndex(TIPOARCO_TRADICIONAL_INDICE);
                break;
            case TIPOARCO_RECURVO_VALOR:
                jComboTipoDeArco.setSelectedIndex(TIPOARCO_RECURVO_INDICE);
                break;
            case TIPOARCO_COMPOSTO_VALOR:
                jComboTipoDeArco.setSelectedIndex(TIPOARCO_COMPOSTO_INDICE);
                break;
        }

        this.atualizarTipoCompetidor();
    }

    private boolean validarCampos() {
        if (jTextFieldNome.getText().trim().length() == 0) {
            this.exibirInformacao("O valor do campo 'Nome' não foi informado.");
            jTextFieldNome.requestFocus();
            return false;
        }
        if (jTextFieldDataNascimento.getText().length() != 0) {
            try {
                dateFormat.parse(jTextFieldDataNascimento.getText());
            } catch (ParseException ex) {
                this.exibirInformacao("O valor do campo 'Data de Nascimento' é inválido.");
                jTextFieldDataNascimento.requestFocus();
                return false;
            }
        }
        try {
            Double.parseDouble(jTextFieldAltura.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Altura' é inválido.");
            jTextFieldAltura.requestFocus();
            return false;
        }
        try {
            Double.parseDouble(jTextFieldPeso.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Peso' é inválido.");
            jTextFieldPeso.requestFocus();
            return false;
        }
        if (!jTextFieldNumero.getText().equals("")) {
            try {
                Integer.parseInt(jTextFieldNumero.getText());
            } catch (Exception ex) {
                this.exibirInformacao("O valor do campo 'Número' é inválido.");
                jTextFieldNumero.requestFocus();
                return false;
            }
        }
        try {
            Double.parseDouble(jTextFieldDistancia.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Distaancia' é inválido.");
            jTextFieldDistancia.requestFocus();
            return false;
        }
        try {
            Integer.parseInt(jTextFieldTotalDeMedalhas.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Total de Medalhas' é inválido.");
            jTextFieldTotalDeMedalhas.requestFocus();
            return false;
        }
        try {
            Integer.parseInt(jTextFieldTotalDesistencias.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Total de Desistencias' é inválido.");
            jTextFieldTotalDesistencias.requestFocus();
            return false;
        }
        try {
            Integer.parseInt(jTextFieldAcertosNaMosca.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Acertos na Mosca' é inválido.");
            jTextFieldAcertosNaMosca.requestFocus();
            return false;
        }
        try {
            Double.parseDouble(jTextFieldTamanhoDoArco.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Tamanho do Arco' é inválido.");
            jTextFieldTamanhoDoArco.requestFocus();
            return false;
        }
        /* try {
            Integer.parseInt(jTextFieldTipoCompetidor.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Total de Vitorias' é inválido.");
            jTextFieldTipoCompetidor.requestFocus();
            return false;
        }
        
            try {
            Integer.parseInt(jTextFieldTipoDeFlecha.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Tipo de Flecha' é inválido.");
            jTextFieldTipoDeFlecha.requestFocus();
            return false;
        }
      */
        return true;
    }

    private void habilitarDesabilitarCampos() {
        boolean registroSelecionado = (umArqueiro != null);
        jTextFieldAltura.setEnabled(modoAlteracao);
        jTextFieldTipoCompetidor.setEnabled(false); 
        jTextFieldBairro.setEnabled(modoAlteracao);
        jTextFieldAlvo.setEnabled(modoAlteracao);
        jTextFieldCep.setEnabled(modoAlteracao);
        jTextFieldCidade.setEnabled(modoAlteracao);
        jTextFieldComplemento.setEnabled(modoAlteracao);
        jTextFieldCpf.setEnabled(modoAlteracao);
        jTextIdade.setEnabled(modoAlteracao);
        jTextFieldDataNascimento.setEnabled(modoAlteracao);
        jTextFieldDistancia.setEnabled(modoAlteracao);
        jComboBoxEstado.setEnabled(modoAlteracao);
        jTextFieldLogradouro.setEnabled(modoAlteracao);
        jTextFieldNome.setEnabled(modoAlteracao);
        jTextFieldNomeMae.setEnabled(modoAlteracao);
        jTextFieldNomePai.setEnabled(modoAlteracao);
        jTextFieldNumero.setEnabled(modoAlteracao);
        jTextFieldPais.setEnabled(modoAlteracao);
        jTextFieldPeso.setEnabled(modoAlteracao);
        jTextFieldRg.setEnabled(modoAlteracao);
        jTextFieldTotalDeMedalhas.setEnabled(modoAlteracao);
        jTextFieldTotalDesistencias.setEnabled(modoAlteracao);
        jTextFieldAcertosNaMosca.setEnabled(modoAlteracao);
        jTextFieldTamanhoDoArco.setEnabled(modoAlteracao);
        jTextFieldTipoCompetidor.setEnabled(false);
        jTextFieldTipoDeFlecha.setEnabled(modoAlteracao);
        jButtonNovo.setEnabled(modoAlteracao == false);
        jButtonAlterar.setEnabled(modoAlteracao == false && registroSelecionado == true);
        jButtonExcluir.setEnabled(modoAlteracao == false && registroSelecionado == true);
        jButtonPesquisar.setEnabled(modoAlteracao == false);
        jButtonSalvar.setEnabled(modoAlteracao);
        jButtonCancelar.setEnabled(modoAlteracao);
        jButtonAdicionarTelefone.setEnabled(modoAlteracao);
        jButtonRemoverTelefone.setEnabled(modoAlteracao);
        jButtonAdicionarPremiacao.setEnabled(modoAlteracao);
        jButtonRemoverPremiacao.setEnabled(modoAlteracao);
        jComboBoxSexo.setEnabled(modoAlteracao);
        jComboModalidade.setEnabled(modoAlteracao);
        jComboTipoDeArco.setEnabled(modoAlteracao);
        jTableListaArqueiros.setEnabled(modoAlteracao == false);
    }

    private void salvarRegistro() {
        Endereco endereco;
        ArrayList<String> telefones;
        ArrayList<Premiacao> premiacoes;
        Date dataNascimento;

        if (this.validarCampos() == false) {
            return;
        }

        if (jTextFieldDataNascimento.getText().length() == 0) {
            dataNascimento = null;
        } else {
            try {
                dataNascimento = dateFormat.parse(jTextFieldDataNascimento.getText());
            } catch (ParseException ex) {
                exibirInformacao("Falha ao gravar a data de nascimento: " + ex.toString());
                return;
            }
        }

        endereco = new Endereco();
        endereco.setBairro(jTextFieldBairro.getText());
        endereco.setCep(jTextFieldCep.getText());
        endereco.setCidade(jTextFieldCidade.getText());
        endereco.setComplemento(jTextFieldComplemento.getText());
        endereco.setEstado((String) jComboBoxEstado.getSelectedItem());
        endereco.setLogradouro(jTextFieldLogradouro.getText());
        endereco.setNumero(jTextFieldNumero.getText());
        endereco.setPais(jTextFieldPais.getText());

        telefones = new ArrayList<String>();
        for (int i = 0; i < telefonesListModel.size(); i++) {
            telefones.add(telefonesListModel.getElementAt(i).toString());
        }

        premiacoes = new ArrayList<Premiacao>();
        for (int i = 0; i < premiacaoListModel.size(); i++) {
            Premiacao premiacao = (Premiacao) premiacaoListModel.getElementAt(i);
            premiacoes.add(premiacao);
        }

        if (novoRegistro == true) {
            umArqueiro = new Arqueiro(jTextFieldNome.getText());
        } else {
            umArqueiro.setNome(jTextFieldNome.getText());
        }
        umArqueiro.setEndereco(endereco);
        umArqueiro.setTelefones(telefones);
        umArqueiro.setPremiacoes(premiacoes);
        umArqueiro.setDataNascimento(dataNascimento);
        umArqueiro.setAltura(Double.parseDouble(jTextFieldAltura.getText()));
        umArqueiro.setAlvo(jTextFieldAlvo.getText());
        umArqueiro.setNomeMae(jTextFieldNomeMae.getText());
        umArqueiro.setNomePai(jTextFieldNomePai.getText());
        umArqueiro.setPeso(Double.parseDouble(jTextFieldPeso.getText()));
        umArqueiro.setCpf(jTextFieldCpf.getText());
        umArqueiro.setRg(jTextFieldRg.getText());
        umArqueiro.setDistancia(Integer.parseInt(jTextFieldDistancia.getText()));
        umArqueiro.setIdade(Integer.parseInt(jTextIdade.getText()));
        umArqueiro.setTotalMedalhas(Integer.parseInt(jTextFieldTotalDeMedalhas.getText()));
        umArqueiro.setTamanhoArco(Double.parseDouble(jTextFieldTamanhoDoArco.getText()));
        umArqueiro.setTotalDesistencias(Integer.parseInt(jTextFieldTotalDesistencias.getText()));
        umArqueiro.setTotalAcertosNaMosca(Integer.parseInt(jTextFieldAcertosNaMosca.getText()));
        umArqueiro.setTipoFlecha(jTextFieldTipoDeFlecha.getText());

        switch (jComboBoxSexo.getSelectedIndex()) {
            case SEXO_MASCULINO_INDICE:
                umArqueiro.setSexo(SEXO_MASCULINO_VALOR);
                break;
            case SEXO_FEMININO_INDICE:
                umArqueiro.setSexo(SEXO_FEMININO_VALOR);
                break;
        }

        switch (jComboModalidade.getSelectedIndex()) {
            case MODALIDADE_OUTDOOR_INDICE:
                umArqueiro.setModalidade(MODALIDADE_OUTDOOR_VALOR);
                break;
            case MODALIDADE_INDOOR_INDICE:
                umArqueiro.setModalidade(MODALIDADE_INDOOR_VALOR);
                break;
            case MODALIDADE_FIELD_INDICE:
                umArqueiro.setModalidade(MODALIDADE_FIELD_VALOR);
                break;
            case MODALIDADE_SKIARCHERY_INDICE:
                umArqueiro.setModalidade(MODALIDADE_SKIARCHERY_VALOR);
                break;
            case MODALIDADE_CLOUT_INDICE:
                umArqueiro.setModalidade(MODALIDADE_CLOUT_VALOR);
                break;
            case MODALIDADE_FLIGHT_INDICE:
                umArqueiro.setModalidade(MODALIDADE_FLIGHT_VALOR);
                break;
        }

        switch (jComboTipoDeArco.getSelectedIndex()) {
            case TIPOARCO_TRADICIONAL_INDICE:
                umArqueiro.setTipoArco(TIPOARCO_TRADICIONAL_VALOR);
                break;
            case TIPOARCO_RECURVO_INDICE:
                umArqueiro.setTipoArco(TIPOARCO_RECURVO_VALOR);
                break;
            case TIPOARCO_COMPOSTO_INDICE:
                umArqueiro.setTipoArco(TIPOARCO_COMPOSTO_VALOR);
                break;
        }

        if (novoRegistro == true) {
            controleArqueiro.adicionar(umArqueiro);
        }
        modoAlteracao = false;
        novoRegistro = false;
        this.carregarListaArqueiros();
        this.habilitarDesabilitarCampos();
    }

    private void carregarListaArqueiros() {
        ArrayList<Arqueiro> listaArqueiros = controleArqueiro.getListaArqueiros();
        DefaultTableModel model = (DefaultTableModel) jTableListaArqueiros.getModel();
        model.setRowCount(0);
        for (Arqueiro b : listaArqueiros) {
            model.addRow(new String[]{b.getNome(), b.getCpf()});
        }
        jTableListaArqueiros.setModel(model);
    }

    private void exibirInformacao(String info) {
        JOptionPane.showMessageDialog(this, info, "Atenção", JOptionPane.INFORMATION_MESSAGE);
    }

    private void atualizarTipoCompetidor() {
        char sexo;
        switch (jComboBoxSexo.getSelectedIndex()) {
            case SEXO_MASCULINO_INDICE:
                sexo = SEXO_MASCULINO_VALOR;
                break;
            case SEXO_FEMININO_INDICE:
               sexo = SEXO_FEMININO_VALOR;
                break;            
            default:
                return;
        }
     if (Integer.parseInt( jTextIdade.getText())!=0)
        {
        jTextFieldTipoCompetidor.setText(Arqueiro.obterCategoriaPorIdadeEsexo(sexo, Integer.parseInt(jTextIdade.getText())));
     }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonNovo = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jLabelDataNascimento = new javax.swing.JLabel();
        jLabelAltura = new javax.swing.JLabel();
        jTextFieldAltura = new javax.swing.JTextField();
        jTextFieldPeso = new javax.swing.JTextField();
        jLabelPeso = new javax.swing.JLabel();
        jTextFieldNomePai = new javax.swing.JTextField();
        jLabelNomePai = new javax.swing.JLabel();
        jTextFieldNomeMae = new javax.swing.JTextField();
        jLabelNomeMae = new javax.swing.JLabel();
        jLabelSexo = new javax.swing.JLabel();
        jLabelRg = new javax.swing.JLabel();
        jLabelCpf = new javax.swing.JLabel();
        jLabelTelefones = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListTelefones = new javax.swing.JList();
        jButtonAdicionarTelefone = new javax.swing.JButton();
        jButtonRemoverTelefone = new javax.swing.JButton();
        jComboBoxSexo = new javax.swing.JComboBox();
        jTextFieldDataNascimento = new javax.swing.JTextField();
        jTextFieldRg = new javax.swing.JTextField();
        jTextFieldCpf = new javax.swing.JTextField();
        jTextIdade = new javax.swing.JTextField();
        jLabelIdade = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelLogradouro = new javax.swing.JLabel();
        jTextFieldLogradouro = new javax.swing.JTextField();
        jLabelNumero = new javax.swing.JLabel();
        jTextFieldNumero = new javax.swing.JTextField();
        jTextFieldBairro = new javax.swing.JTextField();
        jLabelBairro = new javax.swing.JLabel();
        jTextFieldCidade = new javax.swing.JTextField();
        jLabelCidade = new javax.swing.JLabel();
        jLabelEstado = new javax.swing.JLabel();
        jLabelPais = new javax.swing.JLabel();
        jTextFieldPais = new javax.swing.JTextField();
        jLabelComplemento = new javax.swing.JLabel();
        jTextFieldComplemento = new javax.swing.JTextField();
        jLabelCep = new javax.swing.JLabel();
        jComboBoxEstado = new javax.swing.JComboBox();
        jTextFieldCep = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabelModalidade = new javax.swing.JLabel();
        jComboModalidade = new javax.swing.JComboBox();
        jLabelAlvo = new javax.swing.JLabel();
        jLabelTipoDeArco = new javax.swing.JLabel();
        jComboTipoDeArco = new javax.swing.JComboBox();
        jTextFieldDistancia = new javax.swing.JTextField();
        jLabelDistancia = new javax.swing.JLabel();
        jLabelTamanhoDoArco = new javax.swing.JLabel();
        jTextFieldTamanhoDoArco = new javax.swing.JTextField();
        jTextFieldTipoDeFlecha = new javax.swing.JTextField();
        jLabelTipoDeFlecha = new javax.swing.JLabel();
        jTextFieldTipoCompetidor = new javax.swing.JTextField();
        jLabelTipoCompetidor = new javax.swing.JLabel();
        jTextFieldAcertosNaMosca = new javax.swing.JTextField();
        jLabelAcertosNaMosca = new javax.swing.JLabel();
        jLabelTotalDeMedalhas = new javax.swing.JLabel();
        jTextFieldTotalDeMedalhas = new javax.swing.JTextField();
        jLabelTotalDesistencias = new javax.swing.JLabel();
        jTextFieldTotalDesistencias = new javax.swing.JTextField();
        jTextFieldAlvo = new javax.swing.JTextField();
        jLabelPremiacoes = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListPremiacoes = new javax.swing.JList();
        jButtonAdicionarPremiacao = new javax.swing.JButton();
        jButtonRemoverPremiacao = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonPesquisar = new javax.swing.JButton();
        jLabelListaArqueiros = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableListaArqueiros = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jLabelNome.setText("Nome:");

        jLabelDataNascimento.setText("Data de Nascimento:");

        jLabelAltura.setText("Altura:");

        jTextFieldPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPesoActionPerformed(evt);
            }
        });
        jTextFieldPeso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldPesoFocusLost(evt);
            }
        });
        jTextFieldPeso.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextFieldPesoPropertyChange(evt);
            }
        });

        jLabelPeso.setText("Peso:");

        jLabelNomePai.setText("Nome do Pai:");

        jLabelNomeMae.setText("Nome da Mãe:");

        jLabelSexo.setText("Sexo:");

        jLabelRg.setText("RG:");

        jLabelCpf.setText("CPF:");

        jLabelTelefones.setText("Telefones:");

        jListTelefones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jListTelefones);

        jButtonAdicionarTelefone.setText("+");
        jButtonAdicionarTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarTelefoneActionPerformed(evt);
            }
        });

        jButtonRemoverTelefone.setText("-");
        jButtonRemoverTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverTelefoneActionPerformed(evt);
            }
        });

        jComboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));

        jTextFieldDataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDataNascimentoActionPerformed(evt);
            }
        });

        jTextIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextIdadeActionPerformed(evt);
            }
        });
        jTextIdade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextIdadeFocusLost(evt);
            }
        });

        jLabelIdade.setText("Idade:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabelTelefones, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelRg, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelDataNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelSexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabelIdade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelAltura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelPeso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAdicionarTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRemoverTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomeMae, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                    .addComponent(jTextFieldNomePai, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldCpf, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldRg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabelNomePai, jLabelSexo});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDataNascimento)
                            .addComponent(jTextFieldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSexo)
                            .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelPeso))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelAltura)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomePai))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomeMae))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRg)
                    .addComponent(jTextFieldRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCpf)
                    .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAdicionarTelefone)
                            .addComponent(jTextIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelIdade)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonRemoverTelefone)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTelefones)))
        );

        jTabbedPane1.addTab("Informações Gerais", jPanel1);

        jLabelLogradouro.setText("Logradouro:");

        jLabelNumero.setText("Número:");

        jLabelBairro.setText("Bairro:");

        jLabelCidade.setText("Cidade:");

        jLabelEstado.setText("Estado:");

        jLabelPais.setText("País:");

        jLabelComplemento.setText("Complemento:");

        jLabelCep.setText("CEP:");

        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jLabelPais, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jLabelCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jLabelBairro, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jLabelNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jLabelCep, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jLabelEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jLabelLogradouro, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLogradouro, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldCep, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldPais, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextFieldLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabelLogradouro)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumero)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelComplemento)
                    .addComponent(jTextFieldComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBairro)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCidade)
                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPais)
                    .addComponent(jTextFieldPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCep)
                    .addComponent(jTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(133, 133, 133))
        );

        jTabbedPane1.addTab("Endereço", jPanel2);

        jLabelModalidade.setText("Modalidade:");

        jComboModalidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Outdoor", "Indoor", "Field", "Ski-Archery", "Clout", "Flight" }));
        jComboModalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboModalidadeActionPerformed(evt);
            }
        });

        jLabelAlvo.setText("Alvo:");

        jLabelTipoDeArco.setText("Tipo de Arco:");

        jComboTipoDeArco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tradicional", "Recurvo (Olímpico)", "Composto" }));
        jComboTipoDeArco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboTipoDeArcoActionPerformed(evt);
            }
        });

        jLabelDistancia.setText("Distancia:");

        jLabelTamanhoDoArco.setText("Tamanho do Arco:");

        jLabelTipoDeFlecha.setText("Tipo de Flecha:");

        jTextFieldTipoCompetidor.setForeground(new java.awt.Color(9, 4, 4));
        jTextFieldTipoCompetidor.setDisabledTextColor(new java.awt.Color(11, 8, 5));
        jTextFieldTipoCompetidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTipoCompetidorActionPerformed(evt);
            }
        });

        jLabelTipoCompetidor.setText("Tipo de Competidor:");

        jLabelAcertosNaMosca.setText("Total de Acertos na Mosca:");

        jLabelTotalDeMedalhas.setText("Total de Medalhas:");

        jLabelTotalDesistencias.setText("Total de Desistencias:");

        jTextFieldAlvo.setEnabled(false);

        jLabelPremiacoes.setText("Premiações:");

        jScrollPane2.setViewportView(jListPremiacoes);

        jButtonAdicionarPremiacao.setText("+");
        jButtonAdicionarPremiacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarPremiacaoActionPerformed(evt);
            }
        });

        jButtonRemoverPremiacao.setText("-");
        jButtonRemoverPremiacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverPremiacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDistancia)
                    .addComponent(jLabelModalidade)
                    .addComponent(jLabelAlvo)
                    .addComponent(jLabelTipoDeArco)
                    .addComponent(jLabelTamanhoDoArco)
                    .addComponent(jLabelTipoDeFlecha)
                    .addComponent(jLabelTipoCompetidor)
                    .addComponent(jLabelAcertosNaMosca)
                    .addComponent(jLabelTotalDeMedalhas)
                    .addComponent(jLabelTotalDesistencias))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldTotalDesistencias)
                    .addComponent(jTextFieldTotalDeMedalhas)
                    .addComponent(jTextFieldAcertosNaMosca)
                    .addComponent(jTextFieldTipoCompetidor)
                    .addComponent(jTextFieldTipoDeFlecha)
                    .addComponent(jTextFieldTamanhoDoArco)
                    .addComponent(jTextFieldDistancia)
                    .addComponent(jComboTipoDeArco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldAlvo, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                    .addComponent(jComboModalidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPremiacoes)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonRemoverPremiacao, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                            .addComponent(jButtonAdicionarPremiacao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelModalidade)
                            .addComponent(jLabelPremiacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelAlvo)
                            .addComponent(jTextFieldAlvo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboTipoDeArco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTipoDeArco))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDistancia)
                            .addComponent(jTextFieldDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTamanhoDoArco)
                            .addComponent(jTextFieldTamanhoDoArco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTipoDeFlecha)
                            .addComponent(jTextFieldTipoDeFlecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTipoCompetidor)
                            .addComponent(jTextFieldTipoCompetidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelAcertosNaMosca)
                            .addComponent(jTextFieldAcertosNaMosca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotalDeMedalhas)
                            .addComponent(jTextFieldTotalDeMedalhas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotalDesistencias)
                            .addComponent(jTextFieldTotalDesistencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButtonAdicionarPremiacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRemoverPremiacao))
                            .addComponent(jScrollPane2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ficha Técnica", jPanel3);

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonPesquisar.setText("Pesquisar...");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jLabelListaArqueiros.setText("Lista de Arqueiros:");

        jTableListaArqueiros.setModel(new javax.swing.table.DefaultTableModel 
            (
                null,
                new String [] {
                    "Nome", "CPF"
                }
            )
            {
                @Override    
                public boolean isCellEditable(int rowIndex, int mColIndex) {
                    return false;
                }
            });
            jTableListaArqueiros.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jTableListaArqueirosMouseClicked(evt);
                }
            });
            jScrollPane4.setViewportView(jTableListaArqueiros);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelListaArqueiros)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButtonNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonAlterar)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonExcluir)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonPesquisar)
                            .addGap(222, 222, 222)
                            .addComponent(jButtonSalvar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonAlterar, jButtonCancelar, jButtonExcluir, jButtonNovo, jButtonPesquisar, jButtonSalvar});

            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonNovo)
                        .addComponent(jButtonAlterar)
                        .addComponent(jButtonExcluir)
                        .addComponent(jButtonPesquisar)
                        .addComponent(jButtonSalvar)
                        .addComponent(jButtonCancelar))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabelListaArqueiros)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jComboModalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboModalidadeActionPerformed
       
    }//GEN-LAST:event_jComboModalidadeActionPerformed

    private void jComboIdadeActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        this.atualizarTipoCompetidor();
    }    
    
    private void jComboSexoActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        this.atualizarTipoCompetidor();
    }    
    
    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        umArqueiro = null;
        modoAlteracao = true;
        novoRegistro = true;
        this.limparCampos();
        this.habilitarDesabilitarCampos();
        this.jTextFieldNome.requestFocus();
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        this.salvarRegistro();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        if (novoRegistro == true) {
            this.limparCampos();
        } else {
            this.preencherCampos();
        }
        modoAlteracao = false;
        novoRegistro = false;
        this.habilitarDesabilitarCampos();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPesoActionPerformed
    }//GEN-LAST:event_jTextFieldPesoActionPerformed

    private void jTextFieldPesoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextFieldPesoPropertyChange
    }//GEN-LAST:event_jTextFieldPesoPropertyChange

    private void jTextFieldPesoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPesoFocusLost
      this.atualizarTipoCompetidor(); 
    }//GEN-LAST:event_jTextFieldPesoFocusLost

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        modoAlteracao = true;
        novoRegistro = false;
        this.habilitarDesabilitarCampos();
        this.jTextFieldNome.requestFocus();
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        this.controleArqueiro.remover(umArqueiro);
        umArqueiro = null;
        this.limparCampos();
        this.carregarListaArqueiros();
        this.habilitarDesabilitarCampos();
    }//GEN-LAST:event_jButtonExcluirActionPerformed

private void jButtonAdicionarTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarTelefoneActionPerformed
    CadastroTelefone cadastro = new CadastroTelefone(this, true);
    cadastro.setVisible(true);
    if (cadastro.getTelefone() != null) {
        telefonesListModel.addElement(cadastro.getTelefone());
    }
    cadastro.dispose();
}//GEN-LAST:event_jButtonAdicionarTelefoneActionPerformed

private void jButtonRemoverTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverTelefoneActionPerformed
    if (jListTelefones.getSelectedIndex() != -1) {
        telefonesListModel.removeElementAt(jListTelefones.getSelectedIndex());
    }
}//GEN-LAST:event_jButtonRemoverTelefoneActionPerformed

private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
    String pesquisa = JOptionPane.showInputDialog("Informe o nome do Arqueiro.");
    if (pesquisa != null) {
        this.pesquisarArqueiro(pesquisa);
    }
}//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void pesquisarArqueiro(String nome) {
        Arqueiro ArqueiroPesquisado = controleArqueiro.pesquisar(nome);

        if (ArqueiroPesquisado == null) {
            exibirInformacao("Arqueiro não encontrado.");
        } else {
            this.umArqueiro = ArqueiroPesquisado;
            this.preencherCampos();
            this.habilitarDesabilitarCampos();
        }
    }

private void jButtonAdicionarPremiacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarPremiacaoActionPerformed
    CadastroPremiacao cadastro = new CadastroPremiacao(this, true);
    cadastro.setVisible(true);
    if (cadastro.getPremiacao() != null) {
        premiacaoListModel.addElement(cadastro.getPremiacao());
    }
    cadastro.dispose();
}//GEN-LAST:event_jButtonAdicionarPremiacaoActionPerformed

private void jButtonRemoverPremiacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverPremiacaoActionPerformed
    if (jListPremiacoes.getSelectedIndex() != -1) {
        premiacaoListModel.removeElementAt(jListPremiacoes.getSelectedIndex());
    }
}//GEN-LAST:event_jButtonRemoverPremiacaoActionPerformed

private void jTableListaArqueirosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaArqueirosMouseClicked
    if (jTableListaArqueiros.isEnabled()) {
        DefaultTableModel model = (DefaultTableModel) jTableListaArqueiros.getModel();
        String nome = (String) model.getValueAt(jTableListaArqueiros.getSelectedRow(), 0);
        this.pesquisarArqueiro(nome);
    }
}//GEN-LAST:event_jTableListaArqueirosMouseClicked

private void jTextFieldDataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataNascimentoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jTextFieldDataNascimentoActionPerformed

    private void jTextIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextIdadeActionPerformed
       this.atualizarTipoCompetidor();
    }//GEN-LAST:event_jTextIdadeActionPerformed

    private void jComboTipoDeArcoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboTipoDeArcoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboTipoDeArcoActionPerformed

    private void jTextFieldTipoCompetidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTipoCompetidorActionPerformed
     this.atualizarTipoCompetidor();
    }//GEN-LAST:event_jTextFieldTipoCompetidorActionPerformed

    private void jTextIdadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextIdadeFocusLost
        this.atualizarTipoCompetidor();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextIdadeFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarPremiacao;
    private javax.swing.JButton jButtonAdicionarTelefone;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonRemoverPremiacao;
    private javax.swing.JButton jButtonRemoverTelefone;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox jComboBoxEstado;
    private javax.swing.JComboBox jComboBoxSexo;
    private javax.swing.JComboBox jComboModalidade;
    private javax.swing.JComboBox jComboTipoDeArco;
    private javax.swing.JLabel jLabelAcertosNaMosca;
    private javax.swing.JLabel jLabelAltura;
    private javax.swing.JLabel jLabelAlvo;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCep;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelComplemento;
    private javax.swing.JLabel jLabelCpf;
    private javax.swing.JLabel jLabelDataNascimento;
    private javax.swing.JLabel jLabelDistancia;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelIdade;
    private javax.swing.JLabel jLabelListaArqueiros;
    private javax.swing.JLabel jLabelLogradouro;
    private javax.swing.JLabel jLabelModalidade;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNomeMae;
    private javax.swing.JLabel jLabelNomePai;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelPais;
    private javax.swing.JLabel jLabelPeso;
    private javax.swing.JLabel jLabelPremiacoes;
    private javax.swing.JLabel jLabelRg;
    private javax.swing.JLabel jLabelSexo;
    private javax.swing.JLabel jLabelTamanhoDoArco;
    private javax.swing.JLabel jLabelTelefones;
    private javax.swing.JLabel jLabelTipoCompetidor;
    private javax.swing.JLabel jLabelTipoDeArco;
    private javax.swing.JLabel jLabelTipoDeFlecha;
    private javax.swing.JLabel jLabelTotalDeMedalhas;
    private javax.swing.JLabel jLabelTotalDesistencias;
    private javax.swing.JList jListPremiacoes;
    private javax.swing.JList jListTelefones;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableListaArqueiros;
    private javax.swing.JTextField jTextFieldAcertosNaMosca;
    private javax.swing.JTextField jTextFieldAltura;
    private javax.swing.JTextField jTextFieldAlvo;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCep;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldComplemento;
    private javax.swing.JTextField jTextFieldCpf;
    private javax.swing.JTextField jTextFieldDataNascimento;
    private javax.swing.JTextField jTextFieldDistancia;
    private javax.swing.JTextField jTextFieldLogradouro;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNomeMae;
    private javax.swing.JTextField jTextFieldNomePai;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldPais;
    private javax.swing.JTextField jTextFieldPeso;
    private javax.swing.JTextField jTextFieldRg;
    private javax.swing.JTextField jTextFieldTamanhoDoArco;
    private javax.swing.JTextField jTextFieldTipoCompetidor;
    private javax.swing.JTextField jTextFieldTipoDeFlecha;
    private javax.swing.JTextField jTextFieldTotalDeMedalhas;
    private javax.swing.JTextField jTextFieldTotalDesistencias;
    private javax.swing.JTextField jTextIdade;
    // End of variables declaration//GEN-END:variables
}
