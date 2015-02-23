(ns table-flip.core
  (:require [compojure.core :refer :all]
            [hiccup.core :as hiccup]
            [org.httpkit.server :refer [run-server]])) ; httpkit is a server

(defn get-flips
  "Builds a hashmap of the table-flips."
  []
  (let [fliphash (hash-map 
        "flipping"   "(╯°□°)╯︵ ┻━┻"
        "patience"   "┬─┬ ノ( ゜-゜ノ)"
        "pudgy"      "(ノ ゜Д゜)ノ ︵ ┻━┻"
        "battle"     "(╯°□°)╯︵ ┻━┻ ︵ ╯(°□° ╯)"
        "me"         "┬─┬ ︵ /(.□. \\)"
        "aggravated" "(ﾉಥ益ಥ）ﾉ ┻━┻"
        "putback"    "(ノ^_^)ノ┻━┻ ┬─┬ ノ( ^_^ノ)"
        "dude"       "(╯°Д°）╯︵ /(.□ . \\)"
        "emotional"  "(╯'□')╯︵ ┻━┻"
        "freakout"   "(ﾉಥДಥ)ﾉ︵┻━┻･/"
        "hercules"   "(/ .□.)\\ ︵╰(゜Д゜)╯︵ /(.□. \\)"
        "jedi"       "(._.) ~ ︵ ┻━┻"
        "bear"       "ʕノ•ᴥ•ʔノ ︵ ┻━┻"
        "magical"    "(/¯◡ ‿ ◡)/¯ ~ ┻━┻"
        "robot"      "┗[© ♒ ©]┛ ︵ ┻━┻"
        "russia"     "ノ┬─┬ノ ︵ ( \\o°o)\\ "
        "happy"      "┻━┻ ︵ ლ(⌒-⌒ლ)"
        )]
    fliphash))

(defn flip
  [flip-type]
  (get (get-flips) flip-type))

(defn greeting
  []
  (concat (hiccup/html 
           [:h1 "Hello Table Flippers!"]
           [:h2 "Use"]
           (str "To receive flips make a Get request to http://flip.scrumple.net/[desired_flip]")
           [:h2 "The following flips are available:"]
           [:ul (for [x (keys (get-flips))] [:li (str "/" x )])])))

(defroutes table-flip
  (GET "/" [] (greeting))
  (GET "/:name" [name] (flip name)))

(defn -main []
  (run-server table-flip {:port 5000}))
