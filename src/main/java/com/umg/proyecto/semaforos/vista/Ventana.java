package com.umg.proyecto.semaforos.vista;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;

/**
 *
 * @author Jonathan
 */
public class Ventana extends javax.swing.JFrame implements ActionListener {

    Graphics g;

    Semaforo semaforo = new Semaforo();

    Thread algoritmoSemaforo;

    int contador = 0;

    private boolean allTrue = false;

    public Ventana() {
        initComponents();
        //obtener gráficos del panel
        g = panelAlgoritmo.getGraphics();
        btnStart.addActionListener(this);
        btnStop.addActionListener(this);
        btnAddHilo.addActionListener(this);

        btnAddHilo.setVisible(false);

        //inicializacion de clientes
        cliente1.setVisible(false);
        cliente1.setLocation(890, 170);

        cliente2.setVisible(false);
        cliente2.setLocation(890, 170);

        cliente3.setVisible(false);
        cliente3.setLocation(890, 170);

        cliente4.setVisible(false);
        cliente4.setLocation(890, 170);

        cliente5.setVisible(false);
        cliente5.setLocation(890, 170);

        cliente6.setVisible(false);
        cliente6.setLocation(890, 170);

        cliente7.setVisible(false);
        cliente7.setLocation(890, 170);

        cliente8.setVisible(false);
        cliente8.setLocation(890, 170);

        verde.setVisible(true);
        rojo.setVisible(false);

    }

    class Semaforo {

        public void audio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
            File file = new File("src/main/resources/cash (1).wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();
        }

        public void runAudio() {
            try {
                audio();
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        int cliente1x = 890;
        int cliente1y = 170;

        int cliente2x = 890;
        int cliente2y = 170;

        int cliente3x = 890;
        int cliente3y = 170;

        int cliente4x = 890;
        int cliente4y = 170;

        int cliente5x = 890;
        int cliente5y = 170;

        int cliente6x = 890;
        int cliente6y = 170;

        int cliente7x = 890;
        int cliente7y = 170;

        int cliente8x = 890;
        int cliente8y = 170;

        private boolean espacioOcupado1 = false;
        private boolean espacioOcupado2 = false;
        private boolean espacioOcupado3 = false;
        private boolean espacioOcupado4 = false;
        private boolean espacioOcupado5 = false;

        private boolean ventanillaOcupada1 = false;
        private boolean ventanillaOcupada2 = false;
        private boolean ventanillaOcupada3 = false;

        private int clienteWait1 = 0;
        private int clienteWait2 = 0;
        private int clienteWait3 = 0;
        private int clienteWait4 = 0;
        private int clienteWait5 = 0;
        private int clienteWait6 = 0;
        private int clienteWait7 = 0;
        private int clienteWait8 = 0;

        Random random = new Random();

        private int randomWait1 = random.nextInt(200) + 1500;
        private int randomWait2 = random.nextInt(200) + 1500;
        private int randomWait3 = random.nextInt(200) + 1500;
        private int randomWait4 = random.nextInt(200) + 1500;
        private int randomWait5 = random.nextInt(200) + 1500;
        private int randomWait6 = random.nextInt(200) + 1500;
        private int randomWait7 = random.nextInt(200) + 1500;
        private int randomWait8 = random.nextInt(200) + 1500;

        public synchronized void run() throws InterruptedException {
            while (true) {

                cliente1.setLocation(cliente1x, cliente1y);
                cliente2.setLocation(cliente2x, cliente2y);
                cliente3.setLocation(cliente3x, cliente3y);
                cliente4.setLocation(cliente4x, cliente4y);
                cliente5.setLocation(cliente5x, cliente5y);
                cliente6.setLocation(cliente6x, cliente6y);
                cliente7.setLocation(cliente7x, cliente7y);
                cliente8.setLocation(cliente8x, cliente8y);

                //CLIENTE 1
                if (cliente1.isVisible() == true) {

                    if (espacioOcupado1 == false && cliente1x > 300) {
                        cliente1x--;
                    } else if (espacioOcupado2 == false && cliente1x >= 390) {
                        cliente1x--;

                    } else if (espacioOcupado3 == false && cliente1x >= 480) {
                        cliente1x--;

                    } else if (espacioOcupado4 == false && cliente1x >= 570) {
                        cliente1x--;

                    } else if (espacioOcupado5 == false && cliente1x >= 660) {
                        cliente1x--;

                    }

                    if (cliente1x == 300 && (cliente8x == 69 || cliente8x == 890) && (ventanillaOcupada1 == false || ventanillaOcupada2 == false || ventanillaOcupada3 == false)) {
                        cliente1x = 299;
                    }

                    if (cliente1x < 300 && cliente1x >= 70) {
                        if (ventanillaOcupada1 == false) {
                            if (cliente1y != 30) {
                                cliente1y -= 2;
                            } else {
                                cliente1x--;
                            }

                            if (cliente1x == 70 && cliente1y == 30) {
                                ventanillaOcupada1 = true;
                                cliente1x = 69;
                            }

                        } else if (ventanillaOcupada2 == false) {
                            if (cliente1x != 70) {
                                cliente1x--;
                            }

                            if (cliente1x == 70 && cliente1y == 170) {
                                ventanillaOcupada2 = true;
                                cliente1x = 69;
                            }

                        } else if (ventanillaOcupada3 == false) {

                            if (cliente1y != 310) {
                                cliente1y += 2;
                            } else {
                                cliente1x--;
                            }

                            if (cliente1x == 70 && cliente1y == 310) {
                                ventanillaOcupada3 = true;
                                cliente1x = 69;
                            }

                        }
                    }

                    if (cliente1x == 69 && cliente1y == 30) {
                        clienteWait1++;
                        if (clienteWait1 == randomWait1) {
                            randomWait1 = random.nextInt(200) + 1500;
                            clienteWait1 = 0;
                            ventanillaOcupada1 = false;
                            cliente1x = 890;
                            cliente1y = 170;
                            cliente1.setLocation(890, 170);
                            cliente1.setVisible(false);
                            runAudio();
                        }
                    } else if (cliente1x == 69 && cliente1y == 170) {
                        clienteWait1++;
                        if (clienteWait1 == randomWait1) {
                            randomWait1 = random.nextInt(200) + 1500;
                            clienteWait1 = 0;
                            ventanillaOcupada2 = false;
                            cliente1x = 890;
                            cliente1y = 170;
                            cliente1.setLocation(890, 170);
                            cliente1.setVisible(false);
                            runAudio();
                        }
                    } else if (cliente1x == 69 && cliente1y == 310) {
                        clienteWait1++;
                        if (clienteWait1 == randomWait1) {
                            randomWait1 = random.nextInt(200) + 1500;
                            clienteWait1 = 0;
                            ventanillaOcupada3 = false;
                            cliente1x = 890;
                            cliente1y = 170;
                            cliente1.setLocation(890, 170);
                            cliente1.setVisible(false);
                            runAudio();
                        }
                    }
                }

                //CLIENTE 2
                if (cliente2.isVisible() == true) {

                    if (espacioOcupado1 == false && cliente2x > 300) {
                        cliente2x--;
                    } else if (espacioOcupado2 == false && cliente2x >= 390) {
                        cliente2x--;

                    } else if (espacioOcupado3 == false && cliente2x >= 480) {
                        cliente2x--;

                    } else if (espacioOcupado4 == false && cliente2x >= 570) {
                        cliente2x--;

                    } else if (espacioOcupado5 == false && cliente2x >= 660) {
                        cliente2x--;

                    }

                    if (cliente2x == 300 && (cliente1x == 69 || cliente1x == 890) && (ventanillaOcupada1 == false || ventanillaOcupada2 == false || ventanillaOcupada3 == false)) {
                        cliente2x = 299;
                    }

                    if (cliente2x < 300 && cliente2x >= 70) {
                        if (ventanillaOcupada1 == false) {
                            if (cliente2y != 30) {
                                cliente2y -= 2;
                            } else {
                                cliente2x--;
                            }

                            if (cliente2x == 70 && cliente2y == 30) {
                                ventanillaOcupada1 = true;
                                cliente2x = 69;
                            }

                        } else if (ventanillaOcupada2 == false) {
                            if (cliente2x != 70) {
                                cliente2x--;
                            }

                            if (cliente2x == 70 && cliente2y == 170) {
                                ventanillaOcupada2 = true;
                                cliente2x = 69;
                            }

                        } else if (ventanillaOcupada3 == false) {

                            if (cliente2y != 310) {
                                cliente2y += 2;
                            } else {
                                cliente2x--;
                            }

                            if (cliente2x == 70 && cliente2y == 310) {
                                ventanillaOcupada3 = true;
                                cliente2x = 69;
                            }

                        }
                    }

                    if (cliente2x == 69 && cliente2y == 30) {
                        clienteWait2++;
                        if (clienteWait2 == randomWait2) {
                            randomWait2 = random.nextInt(200) + 1500;
                            clienteWait2 = 0;
                            ventanillaOcupada1 = false;
                            cliente2x = 890;
                            cliente2y = 170;
                            cliente2.setLocation(890, 170);
                            cliente2.setVisible(false);
                            runAudio();
                        }
                    } else if (cliente2x == 69 && cliente2y == 170) {
                        clienteWait2++;
                        if (clienteWait2 == randomWait2) {
                            randomWait2 = random.nextInt(200) + 1500;
                            clienteWait2 = 0;
                            ventanillaOcupada2 = false;
                            cliente2x = 890;
                            cliente2y = 170;
                            cliente2.setLocation(890, 170);
                            cliente2.setVisible(false);
                            runAudio();
                        }
                    } else if (cliente2x == 69 && cliente2y == 310) {
                        clienteWait2++;
                        if (clienteWait2 == randomWait2) {
                            randomWait2 = random.nextInt(200) + 1500;
                            clienteWait2 = 0;
                            ventanillaOcupada3 = false;
                            cliente2x = 890;
                            cliente2y = 170;
                            cliente2.setLocation(890, 170);
                            cliente2.setVisible(false);
                            runAudio();
                        }
                    }

                }

                //CLIENTE 3
                if (cliente3.isVisible() == true) {

                    if (espacioOcupado1 == false && cliente3x > 300) {
                        cliente3x--;
                    } else if (espacioOcupado2 == false && cliente3x >= 390) {
                        cliente3x--;

                    } else if (espacioOcupado3 == false && cliente3x >= 480) {
                        cliente3x--;

                    } else if (espacioOcupado4 == false && cliente3x >= 570) {
                        cliente3x--;

                    } else if (espacioOcupado5 == false && cliente3x >= 660) {
                        cliente3x--;

                    }

                    if (cliente3x == 300 && (cliente2x == 69 || cliente2x == 890) && (ventanillaOcupada1 == false || ventanillaOcupada2 == false || ventanillaOcupada3 == false)) {
                        cliente3x = 299;
                    }

                    if (cliente3x < 300 && cliente3x >= 70) {
                        if (ventanillaOcupada1 == false) {
                            if (cliente3y != 30) {
                                cliente3y -= 2;
                            } else {
                                cliente3x--;
                            }

                            if (cliente3x == 70 && cliente3y == 30) {
                                ventanillaOcupada1 = true;
                                cliente3x = 69;
                            }

                        } else if (ventanillaOcupada2 == false) {
                            if (cliente3x != 70) {
                                cliente3x--;
                            }

                            if (cliente3x == 70 && cliente3y == 170) {
                                ventanillaOcupada2 = true;
                                cliente3x = 69;
                            }

                        } else if (ventanillaOcupada3 == false) {

                            if (cliente3y != 310) {
                                cliente3y += 2;
                            } else {
                                cliente3x--;
                            }

                            if (cliente3x == 70 && cliente3y == 310) {
                                ventanillaOcupada3 = true;
                                cliente3x = 69;
                            }

                        }
                    }

                    if (cliente3x == 69 && cliente3y == 30) {
                        clienteWait3++;
                        if (clienteWait3 == randomWait3) {
                            randomWait3 = random.nextInt(200) + 1500;
                            clienteWait3 = 0;
                            ventanillaOcupada1 = false;
                            cliente3x = 890;
                            cliente3y = 170;
                            cliente3.setLocation(890, 170);
                            cliente3.setVisible(false);
                            runAudio();
                        }
                    } else if (cliente3x == 69 && cliente3y == 170) {
                        clienteWait3++;
                        if (clienteWait3 == randomWait3) {
                            randomWait3 = random.nextInt(200) + 1500;
                            clienteWait3 = 0;
                            ventanillaOcupada2 = false;
                            cliente3x = 890;
                            cliente3y = 170;
                            cliente3.setLocation(890, 170);
                            cliente3.setVisible(false);
                            runAudio();
                        }
                    } else if (cliente3x == 69 && cliente3y == 310) {
                        clienteWait3++;
                        if (clienteWait3 == randomWait3) {
                            randomWait3 = random.nextInt(200) + 1500;
                            clienteWait3 = 0;
                            ventanillaOcupada3 = false;
                            cliente3x = 890;
                            cliente3y = 170;
                            cliente3.setLocation(890, 170);
                            cliente3.setVisible(false);
                            runAudio();
                        }
                    }

                }

                //CLIENTE 4
                if (cliente4.isVisible() == true) {

                    if (espacioOcupado1 == false && cliente4x > 300) {
                        cliente4x--;
                    } else if (espacioOcupado2 == false && cliente4x >= 390) {
                        cliente4x--;

                    } else if (espacioOcupado3 == false && cliente4x >= 480) {
                        cliente4x--;

                    } else if (espacioOcupado4 == false && cliente4x >= 570) {
                        cliente4x--;

                    } else if (espacioOcupado5 == false && cliente4x >= 660) {
                        cliente4x--;

                    }

                    if (cliente4x == 300 && (cliente3x == 69 || cliente3x == 890) && (ventanillaOcupada1 == false || ventanillaOcupada2 == false || ventanillaOcupada3 == false)) {
                        cliente4x = 299;
                    }

                    if (cliente4x < 300 && cliente4x >= 70) {
                        if (ventanillaOcupada1 == false) {
                            if (cliente4y != 30) {
                                cliente4y -= 2;
                            } else {
                                cliente4x--;
                            }

                            if (cliente4x == 70 && cliente4y == 30) {
                                ventanillaOcupada1 = true;
                                cliente4x = 69;
                            }

                        } else if (ventanillaOcupada2 == false) {
                            if (cliente4x != 70) {
                                cliente4x--;
                            }

                            if (cliente4x == 70 && cliente4y == 170) {
                                ventanillaOcupada2 = true;
                                cliente4x = 69;
                            }

                        } else if (ventanillaOcupada3 == false) {

                            if (cliente4y != 310) {
                                cliente4y += 2;
                            } else {
                                cliente4x--;
                            }

                            if (cliente4x == 70 && cliente4y == 310) {
                                ventanillaOcupada3 = true;
                                cliente4x = 69;
                            }

                        }
                    }

                    if (cliente4x == 69 && cliente4y == 30) {
                        clienteWait4++;
                        if (clienteWait4 == randomWait4) {
                            randomWait4 = random.nextInt(200) + 1500;
                            clienteWait4 = 0;
                            ventanillaOcupada1 = false;
                            cliente4x = 890;
                            cliente4y = 170;
                            cliente4.setLocation(890, 170);
                            cliente4.setVisible(false);
                            runAudio();
                        }
                    } else if (cliente4x == 69 && cliente4y == 170) {
                        clienteWait4++;
                        if (clienteWait4 == randomWait4) {
                            randomWait4 = random.nextInt(200) + 1500;
                            clienteWait4 = 0;
                            ventanillaOcupada2 = false;
                            cliente4x = 890;
                            cliente4y = 170;
                            cliente4.setLocation(890, 170);
                            cliente4.setVisible(false);
                            runAudio();
                        }
                    } else if (cliente4x == 69 && cliente4y == 310) {
                        clienteWait4++;
                        if (clienteWait4 == randomWait4) {
                            randomWait4 = random.nextInt(200) + 1500;
                            clienteWait4 = 0;
                            ventanillaOcupada3 = false;
                            cliente4x = 890;
                            cliente4y = 170;
                            cliente4.setLocation(890, 170);
                            cliente4.setVisible(false);
                            runAudio();
                        }
                    }

                }

                //CLIENTE 5
                if (cliente5.isVisible() == true) {

                    if (espacioOcupado1 == false && cliente5x > 300) {

                        cliente5x--;

                    } else if (espacioOcupado2 == false && cliente5x >= 390) {
                        cliente5x--;

                    } else if (espacioOcupado3 == false && cliente5x >= 480) {
                        cliente5x--;

                    } else if (espacioOcupado4 == false && cliente5x >= 570) {
                        cliente5x--;

                    } else if (espacioOcupado5 == false && cliente5x >= 660) {
                        cliente5x--;

                    }

                    if (cliente5x == 300 && (cliente4x == 69 || cliente4x == 890) && (ventanillaOcupada1 == false || ventanillaOcupada2 == false || ventanillaOcupada3 == false)) {
                        cliente5x = 299;
                    }

                    if (cliente5x < 300 && cliente5x >= 70) {

                        if (ventanillaOcupada1 == false) {
                            if (cliente5y != 30) {
                                cliente5y -= 2;
                            } else {
                                cliente5x--;
                            }

                            if (cliente5x == 70 && cliente5y == 30) {
                                ventanillaOcupada1 = true;
                                cliente5x = 69;
                            }

                        } else if (ventanillaOcupada2 == false) {
                            if (cliente5x != 70) {
                                cliente5x--;
                            }

                            if (cliente5x == 70 && cliente5y == 170) {
                                ventanillaOcupada2 = true;
                                cliente5x = 69;
                            }

                        } else if (ventanillaOcupada3 == false) {

                            if (cliente5y != 310) {
                                cliente5y += 2;
                            } else {
                                cliente5x--;
                            }

                            if (cliente5x == 70 && cliente5y == 310) {
                                ventanillaOcupada3 = true;
                                cliente5x = 69;
                            }

                        }
                    }

                    if (cliente5x == 69 && cliente5y == 30) {
                        clienteWait5++;
                        if (clienteWait5 == randomWait5) {
                            randomWait5 = random.nextInt(200) + 1500;
                            clienteWait5 = 0;
                            ventanillaOcupada1 = false;
                            cliente5x = 890;
                            cliente5y = 170;
                            cliente5.setLocation(890, 170);
                            cliente5.setVisible(false);
                            runAudio();
                        }
                    } else if (cliente5x == 69 && cliente5y == 170) {
                        clienteWait5++;
                        if (clienteWait5 == randomWait5) {
                            randomWait5 = random.nextInt(200) + 1500;
                            clienteWait5 = 0;
                            ventanillaOcupada2 = false;
                            cliente5x = 890;
                            cliente5y = 170;
                            cliente5.setLocation(890, 170);
                            cliente5.setVisible(false);
                            runAudio();
                        }
                    } else if (cliente5x == 69 && cliente5y == 310) {
                        clienteWait5++;
                        if (clienteWait5 == randomWait5) {
                            randomWait5 = random.nextInt(200) + 1500;
                            clienteWait5 = 0;
                            ventanillaOcupada3 = false;
                            cliente5x = 890;
                            cliente5y = 170;
                            cliente5.setLocation(890, 170);
                            cliente5.setVisible(false);
                            runAudio();
                        }
                    }

                }

                //CLIENTE 6
                if (cliente6.isVisible() == true) {

                    if (espacioOcupado1 == false && cliente6x > 300) {

                        cliente6x--;

                    } else if (espacioOcupado2 == false && cliente6x >= 390) {
                        cliente6x--;

                    } else if (espacioOcupado3 == false && cliente6x >= 480) {
                        cliente6x--;

                    } else if (espacioOcupado4 == false && cliente6x >= 570) {
                        cliente6x--;

                    } else if (espacioOcupado5 == false && cliente6x >= 660) {
                        cliente6x--;

                    }

                    if (cliente6x == 300 && (cliente5x == 69 || cliente5x == 890) && (ventanillaOcupada1 == false || ventanillaOcupada2 == false || ventanillaOcupada3 == false)) {
                        cliente6x = 299;
                    }

                    if (cliente6x < 300 && cliente6x >= 70) {

                        if (ventanillaOcupada1 == false) {
                            if (cliente6y != 30) {
                                cliente6y -= 2;
                            } else {
                                cliente6x--;
                            }

                            if (cliente6x == 70 && cliente6y == 30) {
                                ventanillaOcupada1 = true;
                                cliente6x = 69;
                            }

                        } else if (ventanillaOcupada2 == false) {
                            if (cliente6x != 70) {
                                cliente6x--;
                            }

                            if (cliente6x == 70 && cliente6y == 170) {
                                ventanillaOcupada2 = true;
                                cliente6x = 69;
                            }

                        } else if (ventanillaOcupada3 == false) {

                            if (cliente6y != 310) {
                                cliente6y += 2;
                            } else {
                                cliente6x--;
                            }

                            if (cliente6x == 70 && cliente6y == 310) {
                                ventanillaOcupada3 = true;
                                cliente6x = 69;
                            }

                        }
                    }

                    if (cliente6x == 69 && cliente6y == 30) {
                        clienteWait6++;
                        if (clienteWait6 == randomWait6) {
                            randomWait6 = random.nextInt(200) + 1500;
                            clienteWait6 = 0;
                            ventanillaOcupada1 = false;
                            cliente6x = 890;
                            cliente6y = 170;
                            cliente6.setLocation(890, 170);
                            cliente6.setVisible(false);
                            runAudio();
                        }
                    } else if (cliente6x == 69 && cliente6y == 170) {
                        clienteWait6++;
                        if (clienteWait6 == randomWait6) {
                            randomWait6 = random.nextInt(200) + 1500;
                            clienteWait6 = 0;
                            ventanillaOcupada2 = false;
                            cliente6x = 890;
                            cliente6y = 170;
                            cliente6.setLocation(890, 170);
                            cliente6.setVisible(false);
                            runAudio();
                        }
                    } else if (cliente6x == 69 && cliente6y == 310) {
                        clienteWait6++;
                        if (clienteWait6 == randomWait6) {
                            randomWait6 = random.nextInt(200) + 1500;
                            clienteWait6 = 0;
                            ventanillaOcupada3 = false;
                            cliente6x = 890;
                            cliente6y = 170;
                            cliente6.setLocation(890, 170);
                            cliente6.setVisible(false);
                            runAudio();
                        }
                    }

                }

                //CLIENTE 7
                if (cliente7.isVisible() == true) {

                    if (espacioOcupado1 == false && cliente7x > 300) {

                        cliente7x--;

                    } else if (espacioOcupado2 == false && cliente7x >= 390) {
                        cliente7x--;

                    } else if (espacioOcupado3 == false && cliente7x >= 480) {
                        cliente7x--;

                    } else if (espacioOcupado4 == false && cliente7x >= 570) {
                        cliente7x--;

                    } else if (espacioOcupado5 == false && cliente7x >= 660) {
                        cliente7x--;

                    }

                    if (cliente7x == 300 && (cliente6x == 69 || cliente6x == 890) && (ventanillaOcupada1 == false || ventanillaOcupada2 == false || ventanillaOcupada3 == false)) {
                        cliente7x = 299;
                    }

                    if (cliente7x < 300 && cliente7x >= 70) {

                        if (ventanillaOcupada1 == false) {
                            if (cliente7y != 30) {
                                cliente7y -= 2;
                            } else {
                                cliente7x--;
                            }

                            if (cliente7x == 70 && cliente7y == 30) {
                                ventanillaOcupada1 = true;
                                cliente7x = 69;
                            }

                        } else if (ventanillaOcupada2 == false) {
                            if (cliente7x != 70) {
                                cliente7x--;
                            }

                            if (cliente7x == 70 && cliente7y == 170) {
                                ventanillaOcupada2 = true;
                                cliente7x = 69;
                            }

                        } else if (ventanillaOcupada3 == false) {

                            if (cliente7y != 310) {
                                cliente7y += 2;
                            } else {
                                cliente7x--;
                            }

                            if (cliente7x == 70 && cliente7y == 310) {
                                ventanillaOcupada3 = true;
                                cliente7x = 69;
                            }

                        }
                    }

                    if (cliente7x == 69 && cliente7y == 30) {
                        clienteWait7++;
                        if (clienteWait7 == randomWait7) {
                            randomWait7 = random.nextInt(200) + 1500;
                            clienteWait7 = 0;
                            ventanillaOcupada1 = false;
                            cliente7x = 890;
                            cliente7y = 170;
                            cliente7.setLocation(890, 170);
                            cliente7.setVisible(false);
                            runAudio();
                        }
                    } else if (cliente7x == 69 && cliente7y == 170) {
                        clienteWait7++;
                        if (clienteWait7 == randomWait7) {
                            randomWait7 = random.nextInt(200) + 1500;
                            clienteWait7 = 0;
                            ventanillaOcupada2 = false;
                            cliente7x = 890;
                            cliente7y = 170;
                            cliente7.setLocation(890, 170);
                            cliente7.setVisible(false);
                            runAudio();
                        }
                    } else if (cliente7x == 69 && cliente7y == 310) {
                        clienteWait7++;
                        if (clienteWait7 == randomWait7) {
                            randomWait7 = random.nextInt(200) + 1500;
                            clienteWait7 = 0;
                            ventanillaOcupada3 = false;
                            cliente7x = 890;
                            cliente7y = 170;
                            cliente7.setLocation(890, 170);
                            cliente7.setVisible(false);
                            runAudio();
                        }
                    }

                }

                //CLIENTE 8
                if (cliente8.isVisible() == true) {

                    if (espacioOcupado1 == false && cliente8x > 300) {

                        cliente8x--;

                    } else if (espacioOcupado2 == false && cliente8x >= 390) {
                        cliente8x--;

                    } else if (espacioOcupado3 == false && cliente8x >= 480) {
                        cliente8x--;

                    } else if (espacioOcupado4 == false && cliente8x >= 570) {
                        cliente8x--;

                    } else if (espacioOcupado5 == false && cliente8x >= 660) {
                        cliente8x--;

                    }

                    if (cliente8x == 300 && (cliente7x == 69 || cliente7x == 890) && (ventanillaOcupada1 == false || ventanillaOcupada2 == false || ventanillaOcupada3 == false)) {
                        cliente8x = 299;
                    }

                    if (cliente8x < 300 && cliente8x >= 70) {

                        if (ventanillaOcupada1 == false) {
                            if (cliente8y != 30) {
                                cliente8y -= 2;
                            } else {
                                cliente8x--;
                            }

                            if (cliente8x == 70 && cliente8y == 30) {
                                ventanillaOcupada1 = true;
                                cliente8x = 69;
                            }

                        } else if (ventanillaOcupada2 == false) {
                            if (cliente8x != 70) {
                                cliente8x--;
                            }

                            if (cliente8x == 70 && cliente8y == 170) {
                                ventanillaOcupada2 = true;
                                cliente8x = 69;
                            }

                        } else if (ventanillaOcupada3 == false) {

                            if (cliente8y != 310) {
                                cliente8y += 2;
                            } else {
                                cliente8x--;
                            }

                            if (cliente8x == 70 && cliente8y == 310) {
                                ventanillaOcupada3 = true;
                                cliente8x = 69;
                            }

                        }
                    }

                    if (cliente8x == 69 && cliente8y == 30) {
                        clienteWait8++;
                        if (clienteWait8 == randomWait8) {
                            randomWait8 = random.nextInt(200) + 1500;
                            clienteWait8 = 0;
                            ventanillaOcupada1 = false;
                            cliente8x = 890;
                            cliente8y = 170;
                            cliente8.setLocation(890, 170);
                            cliente8.setVisible(false);
                            runAudio();
                        }
                    } else if (cliente8x == 69 && cliente8y == 170) {
                        clienteWait8++;
                        if (clienteWait8 == randomWait8) {
                            randomWait8 = random.nextInt(200) + 1500;
                            clienteWait8 = 0;
                            ventanillaOcupada2 = false;
                            cliente8x = 890;
                            cliente8y = 170;
                            cliente8.setLocation(890, 170);
                            cliente8.setVisible(false);
                            runAudio();
                        }
                    } else if (cliente8x == 69 && cliente8y == 310) {
                        clienteWait8++;
                        if (clienteWait8 == randomWait8) {
                            randomWait8 = random.nextInt(200) + 1500;
                            clienteWait8 = 0;
                            ventanillaOcupada3 = false;
                            cliente8x = 890;
                            cliente8y = 170;
                            cliente8.setLocation(890, 170);
                            cliente8.setVisible(false);
                            runAudio();
                        }
                    }

                }

                if (cliente1x == 300 || cliente2x == 300 || cliente3x == 300 || cliente4x == 300 || cliente5x == 300 || cliente6x == 300 || cliente7x == 300 || cliente8x == 300) {
                    espacioOcupado1 = true;
                } else {
                    espacioOcupado1 = false;
                }

                if (cliente1x == 390 || cliente2x == 390 || cliente3x == 390 || cliente4x == 390 || cliente5x == 390 || cliente6x == 390 || cliente7x == 390 || cliente8x == 390) {
                    espacioOcupado2 = true;
                } else {
                    espacioOcupado2 = false;
                }

                if (cliente1x == 480 || cliente2x == 480 || cliente3x == 480 || cliente4x == 480 || cliente5x == 480 || cliente6x == 480 || cliente7x == 480 || cliente8x == 480) {
                    espacioOcupado3 = true;
                } else {
                    espacioOcupado3 = false;
                }

                if (cliente1x == 570 || cliente2x == 570 || cliente3x == 570 || cliente4x == 570 || cliente5x == 570 || cliente6x == 570 || cliente7x == 570 || cliente8x == 570) {
                    espacioOcupado4 = true;
                } else {
                    espacioOcupado4 = false;
                }

                if (cliente1x == 660 || cliente2x == 660 || cliente3x == 660 || cliente4x == 660 || cliente5x == 660 || cliente6x == 660 || cliente7x == 660 || cliente8x == 660) {
                    espacioOcupado5 = true;
                } else {
                    espacioOcupado5 = false;
                }

                if (cliente1.isVisible() == true && cliente2.isVisible() == true && cliente3.isVisible() == true && cliente4.isVisible() == true && cliente5.isVisible() == true && cliente6.isVisible() == true && cliente7.isVisible() == true && cliente8.isVisible() == true) {
                    allTrue = true;
                } else {
                    allTrue = false;
                }

                if (ventanillaOcupada1 == true && ventanillaOcupada2 == true && ventanillaOcupada3 == true) {
                    rojo.setVisible(true);
                    verde.setVisible(false);
                } else {
                    verde.setVisible(true);
                    rojo.setVisible(false);
                }

                notify();

                Thread.sleep(5);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnAddHilo = new javax.swing.JButton();
        panelAlgoritmo = new javax.swing.JPanel();
        cliente8 = new javax.swing.JLabel();
        cliente3 = new javax.swing.JLabel();
        cliente5 = new javax.swing.JLabel();
        cliente6 = new javax.swing.JLabel();
        cliente7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cliente2 = new javax.swing.JLabel();
        cliente1 = new javax.swing.JLabel();
        cliente4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rojo = new javax.swing.JPanel();
        verde = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        btnStart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStart.setText("INICIAR");
        jPanel1.add(btnStart);
        btnStart.setBounds(30, 20, 140, 40);

        btnStop.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStop.setText("DETENER");
        jPanel1.add(btnStop);
        btnStop.setBounds(200, 20, 130, 40);

        btnAddHilo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddHilo.setText("Agregar cliente");
        jPanel1.add(btnAddHilo);
        btnAddHilo.setBounds(780, 20, 140, 40);

        panelAlgoritmo.setBackground(new java.awt.Color(153, 204, 255));
        panelAlgoritmo.setLayout(null);

        cliente8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user (1).png"))); // NOI18N
        panelAlgoritmo.add(cliente8);
        cliente8.setBounds(660, 170, 64, 64);

        cliente3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user (1).png"))); // NOI18N
        panelAlgoritmo.add(cliente3);
        cliente3.setBounds(70, 310, 64, 64);

        cliente5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user (1).png"))); // NOI18N
        panelAlgoritmo.add(cliente5);
        cliente5.setBounds(390, 170, 64, 64);

        cliente6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user (1).png"))); // NOI18N
        panelAlgoritmo.add(cliente6);
        cliente6.setBounds(480, 170, 64, 64);

        cliente7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user (1).png"))); // NOI18N
        panelAlgoritmo.add(cliente7);
        cliente7.setBounds(570, 170, 64, 64);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bank_employee64x64.png"))); // NOI18N
        panelAlgoritmo.add(jLabel10);
        jLabel10.setBounds(0, 310, 64, 64);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bank_employee64x64.png"))); // NOI18N
        panelAlgoritmo.add(jLabel11);
        jLabel11.setBounds(0, 30, 60, 64);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bank_employee64x64.png"))); // NOI18N
        panelAlgoritmo.add(jLabel12);
        jLabel12.setBounds(0, 170, 64, 64);

        cliente2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user (1).png"))); // NOI18N
        panelAlgoritmo.add(cliente2);
        cliente2.setBounds(70, 170, 64, 64);

        cliente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user (1).png"))); // NOI18N
        panelAlgoritmo.add(cliente1);
        cliente1.setBounds(70, 30, 64, 64);

        cliente4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user (1).png"))); // NOI18N
        panelAlgoritmo.add(cliente4);
        cliente4.setBounds(300, 170, 64, 64);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/entry_door.png"))); // NOI18N
        panelAlgoritmo.add(jLabel3);
        jLabel3.setBounds(890, 170, 64, 64);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chair.png"))); // NOI18N
        panelAlgoritmo.add(jLabel1);
        jLabel1.setBounds(300, 200, 64, 70);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chair.png"))); // NOI18N
        panelAlgoritmo.add(jLabel2);
        jLabel2.setBounds(390, 200, 60, 70);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chair.png"))); // NOI18N
        panelAlgoritmo.add(jLabel4);
        jLabel4.setBounds(570, 200, 60, 70);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chair.png"))); // NOI18N
        panelAlgoritmo.add(jLabel5);
        jLabel5.setBounds(660, 200, 60, 70);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chair.png"))); // NOI18N
        panelAlgoritmo.add(jLabel6);
        jLabel6.setBounds(480, 200, 60, 70);

        rojo.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout rojoLayout = new javax.swing.GroupLayout(rojo);
        rojo.setLayout(rojoLayout);
        rojoLayout.setHorizontalGroup(
            rojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        rojoLayout.setVerticalGroup(
            rojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        panelAlgoritmo.add(rojo);
        rojo.setBounds(360, 20, 50, 50);

        verde.setBackground(new java.awt.Color(0, 255, 51));

        javax.swing.GroupLayout verdeLayout = new javax.swing.GroupLayout(verde);
        verde.setLayout(verdeLayout);
        verdeLayout.setHorizontalGroup(
            verdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        verdeLayout.setVerticalGroup(
            verdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        panelAlgoritmo.add(verde);
        verde.setBounds(460, 20, 50, 50);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/white_floor.jpg"))); // NOI18N
        panelAlgoritmo.add(jLabel7);
        jLabel7.setBounds(0, 0, 960, 400);

        jPanel1.add(panelAlgoritmo);
        panelAlgoritmo.setBounds(20, 80, 960, 400);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStart) {
            this.algoritmoSemaforo = new Thread(() -> {
                try {
                    semaforo.run();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            //iniciar el hilo
            algoritmoSemaforo.start();

            btnAddHilo.setVisible(true);

        }

        if (e.getSource() == btnStop) {
            algoritmoSemaforo.interrupt();

            btnAddHilo.setVisible(false);
        }

        if (e.getSource() == btnAddHilo) {

            int timeTimer;

            if (allTrue == true) {
                timeTimer = 3500;
            } else {
                timeTimer = 2000;
            }

            btnAddHilo.setVisible(false);

            if (contador != 8) {
                contador++;
            }

            switch (contador) {
                case 1:
                    if (cliente1.isVisible() == false) {
                        cliente1.setVisible(true);
                    } else {
                        contador = 0;
                    }
                    break;
                case 2:
                    if (cliente2.isVisible() == false) {
                        cliente2.setVisible(true);
                    } else {
                        contador = 1;
                    }
                    break;
                case 3:
                    if (cliente3.isVisible() == false) {
                        cliente3.setVisible(true);
                    } else {
                        contador = 2;
                    }
                    break;
                case 4:
                    if (cliente4.isVisible() == false) {
                        cliente4.setVisible(true);
                    } else {
                        contador = 3;
                    }
                    break;
                case 5:
                    if (cliente5.isVisible() == false) {
                        cliente5.setVisible(true);
                    } else {
                        contador = 4;
                    }
                    break;
                case 6:
                    if (cliente6.isVisible() == false) {
                        cliente6.setVisible(true);
                    } else {
                        contador = 5;
                    }
                    break;
                case 7:
                    if (cliente7.isVisible() == false) {
                        cliente7.setVisible(true);
                    } else {
                        contador = 6;
                    }
                    break;
                case 8:
                    if (cliente8.isVisible() == false) {
                        contador = 0;
                        cliente8.setVisible(true);
                    } else {
                        contador = 7;
                    }
                    break;
                default:
                    System.out.println("Ocurrió un error");
                    break;
            }

            // Crear un Timer para que el botón se muestre después de 1 segundo (1000 milisegundos)
            Timer timer = new Timer(timeTimer, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    // Volver a mostrar el botón
                    btnAddHilo.setVisible(true);
                }
            });

            // Configurar el Timer para que solo ejecute la acción una vez
            timer.setRepeats(false);

            // Iniciar el Timer
            timer.start();

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddHilo;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JLabel cliente1;
    private javax.swing.JLabel cliente2;
    private javax.swing.JLabel cliente3;
    private javax.swing.JLabel cliente4;
    private javax.swing.JLabel cliente5;
    private javax.swing.JLabel cliente6;
    private javax.swing.JLabel cliente7;
    private javax.swing.JLabel cliente8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelAlgoritmo;
    private javax.swing.JPanel rojo;
    private javax.swing.JPanel verde;
    // End of variables declaration//GEN-END:variables
}
