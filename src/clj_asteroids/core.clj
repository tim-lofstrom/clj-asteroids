(ns clj-asteroids.core
  (:import [javax.swing JFrame JPanel JLabel]
           [java.awt Dimension]))

(defn my-panel []
  (let [panel (JPanel.)
        label (JLabel. "Hello")]
    (doto panel
      (.add label)
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