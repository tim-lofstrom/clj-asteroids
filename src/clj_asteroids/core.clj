(ns clj-asteroids.core
  (:import [javax.swing JFrame JPanel]
           [java.awt Dimension Color]
           [java.awt.image BufferedImage]))

(defn my-display []
  (let [display (proxy [javax.swing.JPanel] []
                  (paintComponent [g]
                    (proxy-super paintComponent g)))]
    display))


(defn my-panel []
  (let [panel (JPanel.)]
    (doto panel
      (.setFocusable true)
      (.add (my-display))
      (.setBackground (Color/black))
      (.setPreferredSize (Dimension. 800 600)))
    panel))

(defn create-gui []
  (let [frame (JFrame. "Asteroids")]
  (doto frame
    (.add (my-panel))
    (.setDefaultCloseOperation JFrame/EXIT_ON_CLOSE)
    (.pack)
    (.setVisible true))))

(defn -main []
  (create-gui))