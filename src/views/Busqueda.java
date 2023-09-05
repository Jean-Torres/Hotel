package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import controllers.ControllerLogica;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import model.Huespedes;
import model.Reservas;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

    private final JPanel contentPane;
    private final JTextField txtBuscar;
    private final JTable tbHuespedes;
    private final JTable tbReservas;
    private final DefaultTableModel modelo;
    private final DefaultTableModel modeloHuesped;
    private JLabel labelAtras;
    private JLabel labelExit;
    int xMouse, yMouse;
    private final ControllerLogica ctrl;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Busqueda frame = new Busqueda();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Busqueda() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 910, 571);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        setUndecorated(true);

        txtBuscar = new JTextField();
        txtBuscar.setBounds(536, 127, 200, 31);
        txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtBuscar);
        txtBuscar.setColumns(10);

        txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (txtBuscar.getText().length() < 10) {
                    char c = e.getKeyChar();
                    if (c < '0' || c > '9') {
                        e.consume();
                    }
                } else {
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });

        JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
        lblNewLabel_4.setForeground(new Color(12, 138, 199));
        lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
        lblNewLabel_4.setBounds(331, 62, 280, 42);
        contentPane.add(lblNewLabel_4);

        JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
        panel.setBackground(new Color(12, 138, 199));
        panel.setFont(new Font("Roboto", Font.PLAIN, 16));
        panel.setBounds(20, 169, 865, 328);
        contentPane.add(panel);

        tbReservas = new JTable();
        tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
        modelo = (DefaultTableModel) tbReservas.getModel();
        modelo.addColumn("Numero de Reserva");
        modelo.addColumn("Fecha Check In");
        modelo.addColumn("Fecha Check Out");
        modelo.addColumn("Valor");
        modelo.addColumn("Forma de Pago");
        JScrollPane scroll_table = new JScrollPane(tbReservas);
        panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_table, null);
        scroll_table.setVisible(true);

        tbHuespedes = new JTable();
        tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
        modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
        modeloHuesped.addColumn("Número de Huesped");
        modeloHuesped.addColumn("Nombre");
        modeloHuesped.addColumn("Apellido");
        modeloHuesped.addColumn("Fecha de Nacimiento");
        modeloHuesped.addColumn("Nacionalidad");
        modeloHuesped.addColumn("Telefono");
        modeloHuesped.addColumn("Número de Reserva");
        JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
        panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), scroll_tableHuespedes, null);
        scroll_tableHuespedes.setVisible(true);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
        lblNewLabel_2.setBounds(56, 51, 104, 107);
        contentPane.add(lblNewLabel_2);

        JPanel header = new JPanel();
        header.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                headerMouseDragged(e);

            }
        });
        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                headerMousePressed(e);
            }
        });
        header.setLayout(null);
        header.setBackground(Color.WHITE);
        header.setBounds(0, 0, 910, 36);
        contentPane.add(header);

        JPanel btnAtras = new JPanel();
        btnAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuUsuario usuario = new MenuUsuario();
                usuario.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAtras.setBackground(new Color(12, 138, 199));
                labelAtras.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAtras.setBackground(Color.white);
                labelAtras.setForeground(Color.black);
            }
        });
        btnAtras.setLayout(null);
        btnAtras.setBackground(Color.WHITE);
        btnAtras.setBounds(0, 0, 53, 36);
        header.add(btnAtras);

        labelAtras = new JLabel("<");
        labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
        labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
        labelAtras.setBounds(0, 0, 53, 36);
        btnAtras.add(labelAtras);

        JPanel btnexit = new JPanel();
        btnexit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuUsuario usuario = new MenuUsuario();
                usuario.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
                btnexit.setBackground(Color.red);
                labelExit.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
                btnexit.setBackground(Color.white);
                labelExit.setForeground(Color.black);
            }
        });

        btnexit.setLayout(null);
        btnexit.setBackground(Color.WHITE);
        btnexit.setBounds(857, 0, 53, 36);
        header.add(btnexit);

        labelExit = new JLabel("X");
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setForeground(Color.BLACK);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelExit.setBounds(0, 0, 53, 36);
        btnexit.add(labelExit);

        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setForeground(new Color(12, 138, 199));
        separator_1_2.setBackground(new Color(12, 138, 199));
        separator_1_2.setBounds(539, 159, 193, 2);
        contentPane.add(separator_1_2);

        JPanel btnbuscar = new JPanel();
        btnbuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        btnbuscar.setLayout(null);
        btnbuscar.setBackground(new Color(12, 138, 199));
        btnbuscar.setBounds(748, 125, 122, 35);
        btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnbuscar);

        btnbuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!txtBuscar.getText().trim().equals("")) {
                    int id = Integer.parseInt(txtBuscar.getText().trim());
                    int indixe = panel.getSelectedIndex();
                    searchRecord(id, indixe);
                }
            }
        });

        JLabel lblBuscar = new JLabel("BUSCAR");

        lblBuscar.setBounds(0, 0, 122, 35);
        btnbuscar.add(lblBuscar);

        lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);

        lblBuscar.setForeground(Color.WHITE);

        lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));

        JPanel btnEditar = new JPanel();

        btnEditar.setLayout(null);
        btnEditar.setBackground(new Color(12, 138, 199));
        btnEditar.setBounds(635, 508, 122, 35);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnEditar);

        btnEditar.addMouseListener(
                new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e
            ) {
                if (editRecord(panel.getSelectedIndex())) {
                    Exito exito = new Exito("Datos actualizados satisfactoriamente.");
                    exito.setVisible(true);
                } else {
                    Exito exito = new Exito("No hay datos para actualzar.");
                    exito.setVisible(true);
                }
            }
        }
        );

        JLabel lblEditar = new JLabel("EDITAR");

        lblEditar.setHorizontalAlignment(SwingConstants.CENTER);

        lblEditar.setForeground(Color.WHITE);

        lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblEditar.setBounds(0, 0, 122, 35);
        btnEditar.add(lblEditar);

        JPanel btnEliminar = new JPanel();

        btnEliminar.setLayout(null);
        btnEliminar.setBackground(new Color(12, 138, 199));
        btnEliminar.setBounds(767, 508, 122, 35);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnEliminar);

        btnEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (deleteRecord(panel.getSelectedIndex())) {
                    Exito exito = new Exito("Registros eliminados satisfactoriamente.");
                    exito.setVisible(true);
                } else {
                    Exito exito = new Exito("Error al eliminar los  registros.");
                    exito.setVisible(true);
                }
            }
        }
        );

        JLabel lblEliminar = new JLabel("ELIMINAR");

        lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);

        lblEliminar.setForeground(Color.WHITE);

        lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblEliminar.setBounds(0, 0, 122, 35);
        btnEliminar.add(lblEliminar);

        setResizable(false);

        ctrl = new ControllerLogica();

        loadTable();
    }

//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
    private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }

    private void loadReservas() {
        ArrayList<Reservas> reservas = ctrl.FindAllReservas();

        for (Reservas res : reservas) {
            Vector reserva = new Vector();
            reserva.add(res.getId());
            reserva.add(formatDate(res.getFechaEntrada()));
            reserva.add(formatDate(res.getFechaSalida()));
            reserva.add(res.getValorPagado());
            reserva.add(res.getFormaDePago());
            modelo.addRow(reserva);
        }
    }

    private void loadHuesped() {
        ArrayList<Huespedes> huesped = ctrl.FindAllHuespedes();

        for (Huespedes hd : huesped) {
            Vector reserva = new Vector();
            reserva.add(hd.getId());
            reserva.add(hd.getNombres());
            reserva.add(hd.getApellidos());
            reserva.add(formatDate(hd.getFechaNacimiento()));
            reserva.add(hd.getNacionalidad());
            reserva.add(hd.getTelefono());
            reserva.add(hd.getReserva().getId());
            modeloHuesped.addRow(reserva);
        }
    }

    private void loadTable() {
        loadReservas();
        loadHuesped();
    }

    private void searchRecord(int id, int indixe) {
        if (indixe == 0) {
            try {
                Reservas res = ctrl.FindOneReserva(id);
                Vector reserva = new Vector();
                reserva.add(res.getId());
                reserva.add(formatDate(res.getFechaEntrada()));
                reserva.add(formatDate(res.getFechaSalida()));
                reserva.add(res.getValorPagado());
                reserva.add(res.getFormaDePago());
                this.modelo.getDataVector().clear();
                this.modelo.addRow(reserva);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "La reserva con el Id: " + txtBuscar.getText() + " no existe");
            }

        } else {
            try {
                Huespedes hd = ctrl.FindOneHuespedes(id);
                Vector reserva = new Vector();
                reserva.add(hd.getId());
                reserva.add(hd.getNombres());
                reserva.add(hd.getApellidos());
                reserva.add(formatDate(hd.getFechaNacimiento()));
                reserva.add(hd.getNacionalidad());
                reserva.add(hd.getTelefono());
                reserva.add(hd.getReserva().getId());
                this.modeloHuesped.getDataVector().clear();
                modeloHuesped.addRow(reserva);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "El huesped con el Id: " + txtBuscar.getText() + " no existe");
            }
        }
    }

    private boolean editRecord(int index) {
        boolean answer = false;
        if (index == 0) {
            if (tbReservas.getSelectedRow() != -1) {
                int row = tbReservas.getSelectedRow();
                Reservas res = ctrl.FindOneReserva((int) tbReservas.getValueAt(row, 0));

                if (!formatDate(res.getFechaEntrada()).toString().equals(tbReservas.getValueAt(row, 1).toString())) {
                    res.setFechaEntrada(formatString(tbReservas.getValueAt(row, 1).toString()));
                    ctrl.EditReserva(res);
                    answer = true;
                }
                if (!formatDate(res.getFechaSalida()).toString().equals(tbReservas.getValueAt(row, 2).toString())) {
                    res.setFechaSalida(formatString(tbReservas.getValueAt(row, 2).toString()));
                    ctrl.EditReserva(res);
                    answer = true;
                }
                if (res.getValorPagado() != Double.parseDouble(tbReservas.getValueAt(row, 3).toString())) {
                    res.setValorPagado(Double.parseDouble(tbReservas.getValueAt(row, 3).toString()));
                    ctrl.EditReserva(res);
                    answer = true;
                }
                if (!res.getFormaDePago().toString().equals(tbReservas.getValueAt(row, 4).toString())) {
                    res.setFormaDePago(tbReservas.getValueAt(row, 4).toString());
                    ctrl.EditReserva(res);
                    answer = true;
                }
            }
        } else {
            if (tbHuespedes.getSelectedRow() != -1) {
                int row = tbHuespedes.getSelectedRow();
                Huespedes hpd = ctrl.FindOneHuespedes((int) tbHuespedes.getValueAt(row, 0));
                if (!hpd.getNombres().equals(tbHuespedes.getValueAt(row, 1).toString())) {
                    hpd.setNombres(tbHuespedes.getValueAt(row, 1).toString());
                    ctrl.EditHuespedes(hpd);
                    answer = true;
                }
                if (!hpd.getApellidos().equals(tbHuespedes.getValueAt(row, 2).toString())) {
                    hpd.setApellidos(tbHuespedes.getValueAt(row, 2).toString());
                    ctrl.EditHuespedes(hpd);
                    answer = true;
                }
                if (!formatDate(hpd.getFechaNacimiento()).toString().equals(tbHuespedes.getValueAt(row, 3).toString())) {
                    hpd.setFechaNacimiento(formatString(tbHuespedes.getValueAt(row, 3).toString()));
                    ctrl.EditHuespedes(hpd);
                    answer = true;
                }
                if (!hpd.getNacionalidad().equals(tbHuespedes.getValueAt(row, 4).toString())) {
                    hpd.setNacionalidad(tbHuespedes.getValueAt(row, 4).toString());
                    ctrl.EditHuespedes(hpd);
                    answer = true;
                }
                if (!hpd.getTelefono().equals(tbHuespedes.getValueAt(row, 5).toString())) {
                    hpd.setTelefono(tbHuespedes.getValueAt(row, 5).toString());
                    ctrl.EditHuespedes(hpd);
                    answer = true;
                }
            }
        }
        return answer;
    }

    private boolean deleteRecord(int index) {
        boolean answer = false;
        int id, row;
        if (tbHuespedes.getSelectedRow() != -1 || tbReservas.getSelectedRow() != -1) {
            try {
                if (index == 0) {
                    row = tbReservas.getSelectedRow();
                    id = (int) tbReservas.getValueAt(row, 0);
                } else {
                    row = tbHuespedes.getSelectedRow();
                    id = (int) tbHuespedes.getValueAt(row, 0);
                }
                ctrl.DeleteHuespedes(id);
                ctrl.DeleteReserva(id);

                modelo.removeRow(row);
                modeloHuesped.removeRow(row);
                answer = true;
            } catch (Exception e) {
                answer = false;
            }
        }
        return answer;
    }

    private String formatDate(Date date) {
        String format = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    private Date formatString(String date) {
        String format = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(date);
        } catch (ParseException ex) {
            System.err.println("it don't parsear the string");
        }
        return null;
    }
}
