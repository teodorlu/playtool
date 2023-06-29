(ns teodorlu.playtool
  (:require
   [babashka.process :refer [shell]]
   [clojure.edn :as edn]))

;; A tool for playing with knowledge from https://play.teod.eu/

;; Observations:
;;
;;  1. There's a lot of indicental stuff in the play.teod.eu repo
;;  2. All that incidental stuff is making it harder to focus
;;  3. I'll try experiementing here a bit on the side to see if that helps.
;;
;; Method:
;;
;;  1. Try to build on the tools from https://play.teod.eu/ where possible
;;  2. But the goal is to be able to delete code in https://github.com/teodorlu/play.teod.eu
;;
;; Second system, here we come.

(def play-folder "/home/teodorlu/dev/teodorlu/play.teod.eu")

(defn old-play* [& args]
  (apply shell
          {:dir play-folder :out :string}
         "./play.clj"
         args))

(defn old-play [& args]
  (:out (apply old-play* args)))

(defn relations []
  (edn/read-string (old-play "relations" "--from" "files" "--to" "pretty")))

(relations)
