/*
 * Copyright 2017 José A. Pacheco Ondoño - joanpaon@gmail.com.
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
package org.japo.java.libraries;

import java.awt.GraphicsEnvironment;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class UtilesSwing {

    // Asignar Favicon Ventana
    public static void establecerFavicon(JFrame ventana, String rutaFavicon) {
        // Ruta Favicon > URL Favicon
        URL urlICN = ClassLoader.getSystemResource(rutaFavicon);

        // URL Favicon > Ventana Favicon
        ventana.setIconImage(new ImageIcon(urlICN).getImage());
    }

    // Cambiar Valor sin Disparar Eventos Ajuste
    public static void ajustarValorDeslizador(JSlider sldActual, int valor) {
        // Referenciar Escuchadores Eventos Ajuste
        ChangeListener[] lista = sldActual.getChangeListeners();

        // Desconectar Escuchadores del Deslizador
        for (ChangeListener listener : lista) {
            sldActual.removeChangeListener(listener);
        }

        // Esteblece el Nuevo Valor
        sldActual.setValue(valor);

        // Reconectar Escuchadores del Deslizador
        for (ChangeListener listener : lista) {
            sldActual.addChangeListener(listener);
        }
    }

    // Cambiar Valor sin Disparar Eventos Ajuste
    public static void ajustarValorCambiador(JSpinner spnActual, int valor) {
        // Referenciar Escuchadores Eventos Ajuste
        ChangeListener[] lista = spnActual.getChangeListeners();

        /**
         * Desactiva el primer ChangeListener para que no se propaguen eventos.
         * Si se desconectan todos los escuchadores el JSpinner no se actualiza
         * con el valor cambiado por el método setValue
         */
        spnActual.removeChangeListener(lista[0]);

        // Esteblece el Nuevo Valor
        spnActual.setValue(valor);

        // Reconectar Escuchadores del Deslizador
        spnActual.addChangeListener(lista[0]);
    }

    // Tipografias disponibles en el sistema
    public static String[] obtenerTipografiasSistema() {
        return GraphicsEnvironment.
                getLocalGraphicsEnvironment().
                getAvailableFontFamilyNames();
    }
}
