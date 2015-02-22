(ns table-flip.core
  (:require [compojure.core :refer :all]
            [org.httpkit.server :refer [run-server]])) ; httpkit is a server

(defn flip
  [flip-type]
  (let [flips 
        {
         "flipping"     "(╯°□°)╯︵ ┻━┻"
         "patience"   "┬─┬ ノ( ゜-゜ノ)"
         "pudgy"	    "(ノ ゜Д゜)ノ ︵ ┻━┻"
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
         }]
    (get flips flip-type)))

(defroutes table-flip
  (GET "/" [] "Hello Table-Flipperz!")
  (GET "/:name" [name] (flip name)))

(defn -main []
  (run-server table-flip {:port 5000}))
