# table-flip

A Clojure compojure app designed to ... flip tables!

A rewrite in clojure of lyonsinbeta's app: [Table Flipping as a Service (TFAAS)](https://github.com/lyonsinbeta/table-flip).

## Usage

```
lein run -m table-flip.core
```

## Create an uberjar for deployment
create an uberjar
```
lein uberjar
```
this will create target/table-flip-0.1.0-SNAPSHOT.jar which can be run with:
```
java -jar target/table-flip-0.1.0-SNAPSHOT.jar 
```


## License

Copyright © 2015 Bart Lantz

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
