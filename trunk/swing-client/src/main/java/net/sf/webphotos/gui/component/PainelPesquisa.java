/**
 * Copyright 2008 WebPhotos
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.sf.webphotos.gui.component;

/**
 * PainelPesquisa.java
 *
 * Created on 13 de Janeiro de 2006, 12:33
 */
import java.awt.event.MouseListener;
import java.io.Serializable;
import javax.swing.JPanel;
import net.sf.webphotos.action.AcaoPopup;

/**
 * Desenvolve um painel para pesquisas. Atrav�s do construtor, trabalha os
 * eventos para obter o resultado das pesquisas.
 *
 * @author guilherme
 */
public class PainelPesquisa extends JPanel implements Serializable {
    
    private AcaoPopup acaoPesquisa;

    /**
     * Construtor da classe. Chama o m�todo initComponents(), respons�vel por
     * gerar o painel. Trata os eventos e as a��es de pesquisa.
     */
    public PainelPesquisa() {
        initComponents();

        // ACAO PESQUISA
        // TODO: Reformular esse trecho (ver vers�o anterior)
        //acaoPesquisa = new AcaoPesquisa(lstCategoriasPesquisa, txtPesquisa, tbAlbuns);
        //btPesquisar.addActionListener(acaoPesquisa);
//        txtPesquisa.registerKeyboardAction(acaoPesquisa,
//                javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0),
//                javax.swing.JComponent.WHEN_FOCUSED);

        // XXX: Incompat�vel como componente
        //popupAction = (AcaoPopup) ApplicationContextResource.getBean("acaoPopup");;;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelBusca = new javax.swing.JPanel();
        lblPesquisar = new javax.swing.JLabel();
        lstCategoriasPesquisa = new javax.swing.JComboBox();
        lblPalavras = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        btPesquisar = new javax.swing.JButton();
        painelSQL = new javax.swing.JPanel();
        btFiltro = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(65534, 35));
        setMinimumSize(new java.awt.Dimension(550, 35));
        setPreferredSize(new java.awt.Dimension(780, 35));
        setLayout(new java.awt.BorderLayout());

        painelBusca.setMaximumSize(new java.awt.Dimension(32767, 35));
        painelBusca.setPreferredSize(new java.awt.Dimension(461, 35));
        painelBusca.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblPesquisar.setText("Pesquisar em");
        painelBusca.add(lblPesquisar);
        painelBusca.add(lstCategoriasPesquisa);

        lblPalavras.setText("palavra(s)");
        painelBusca.add(lblPalavras);

        txtPesquisa.setMinimumSize(new java.awt.Dimension(192, 19));
        txtPesquisa.setPreferredSize(new java.awt.Dimension(192, 19));
        painelBusca.add(txtPesquisa);

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/zoom16.gif"))); // NOI18N
        btPesquisar.setText("pesquisar");
        painelBusca.add(btPesquisar);

        add(painelBusca, java.awt.BorderLayout.CENTER);

        painelSQL.setMaximumSize(new java.awt.Dimension(32767, 35));
        painelSQL.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btFiltro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sql.gif"))); // NOI18N
        painelSQL.add(btFiltro);

        add(painelSQL, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFiltro;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JLabel lblPalavras;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JComboBox lstCategoriasPesquisa;
    private javax.swing.JPanel painelBusca;
    private javax.swing.JPanel painelSQL;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
    // Bean Variables
    private javax.swing.ComboBoxModel categoriasPesquisaComboBoxModel;

    /**
     * Retorna a {@link javax.swing.ComboBoxModel ComboBoxModel}
     * categoriasPesquisaComboBoxModel.
     *
     * @return Retorna uma ComboBoxModel.
     */
    public javax.swing.ComboBoxModel getCategoriasPesquisaComboBoxModel() {
        return categoriasPesquisaComboBoxModel;
    }

    /**
     * Seta a {@link javax.swing.ComboBoxModel ComboBoxModel}
     * categoriasPesquisaComboBoxModel.
     *
     * @param lstCategoriasPesquisaModel Modelo de lista de categorias para a
     * pesquisa.
     */
    public void setCategoriasPesquisaComboBoxModel(javax.swing.ComboBoxModel lstCategoriasPesquisaModel) {
        this.categoriasPesquisaComboBoxModel = lstCategoriasPesquisaModel;
        lstCategoriasPesquisa.setModel(this.categoriasPesquisaComboBoxModel);
    }

    /**
     * @param popupAction the popupAction to add
     */
    public void addPopupMouseListener(MouseListener popupAction) {
        btFiltro.addMouseListener(popupAction);
    }
    
    /**
     * @param popupAction the popupAction to remove
     */
    public void removePopupMouseListener(MouseListener popupAction) {
        btFiltro.removeMouseListener(popupAction);
    }

    /**
     * @return the acaoPesquisa
     */
    public AcaoPopup getAcaoPesquisa() {
        return acaoPesquisa;
    }

    /**
     * @param acaoPesquisa the acaoPesquisa to set
     */
    public void setAcaoPesquisa(AcaoPopup acaoPesquisa) {
        this.acaoPesquisa = acaoPesquisa;
    }
}
