import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

////порт- идентификатор, чтобы определить получателя
////Сокеты- комбинация IP-адреса и порта
public class EchoClient extends JFrame {
    private final String SERVER_ADDR = "localhost"; //константа, адрес сервера
    private final int SERVER_PORT = 8189; //константа, содержащая порт сервера (8189).
    private JTextField msgInputField; //техстовое поле для ввода
    private JTextArea chatArea; // текстовое поле для вывод
    private Socket socket; //сокет для соединения с сервером.
    private DataInputStream in; //поток ввода данных для чтения
    private DataOutputStream out; //поток вывода
    public EchoClient() { //инициализирующий соединение с сервером
        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        prepareGUI();
    }
    public void openConnection() throws IOException {
        socket = new Socket(SERVER_ADDR, SERVER_PORT); //Создание сокета для соединения
        in = new DataInputStream(socket.getInputStream()); //Получение потока ввода данных
        out = new DataOutputStream(socket.getOutputStream()); //Получение потока вывода
        new Thread(new Runnable() { //Создание и запуск нового потока для приема сообщений
            @Override
            public void run() {
                try {
                    while (true) { //цикл
                        String strFromServer = in.readUTF(); //чтение
                        if (strFromServer.equalsIgnoreCase("/end")) { //проверк закрытия
                            break;
                        }
                        chatArea.append(strFromServer); //вывод
                        chatArea.append("\n"); //новая строка
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public void closeConnection() { //закрытие
        //  метод гарантирует корректное закрытие ресурсов
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendMessage() {
        if (!msgInputField.getText().trim().isEmpty()) { //проверка тестовое поле не пусто ли
            try {
                out.writeUTF(msgInputField.getText()); //отправка сообщения
                msgInputField.setText(""); //очистка
                msgInputField.grabFocus(); //обратка
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ошибка отправки сообщения");
            }
        }
    }
    public void prepareGUI() {
        // Параметры окна
        setBounds(600, 300, 500, 500);
        setTitle("Клиент");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Текстовое поле для вывода сообщений
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);
        // Нижняя панель с полем для ввода сообщений и кнопкой отправки сообщений
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JButton btnSendMsg = new JButton("Отправить");
        bottomPanel.add(btnSendMsg, BorderLayout.EAST);
        msgInputField = new JTextField();
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(msgInputField, BorderLayout.CENTER);
        btnSendMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        msgInputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        // Настраиваем действие на закрытие окна
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    out.writeUTF("/end");
                    closeConnection();
                } catch (IOException exc) {
                    exc.printStackTrace();
                }
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EchoClient();
            }
        });
    }
}