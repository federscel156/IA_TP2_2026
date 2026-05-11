# IA_TP2_2026
TP2 Inteligencia artificial siglo 21 2026
ejecutar 
fede@MacBook-Pro-de-fede TP2 % javac codigo/BusquedaExhaustiva.java
fede@MacBook-Pro-de-fede TP2 % java -cp codigo BusquedaExhaustiva
=== Búsqueda exhaustiva ===
Estado inicial: (H=0, θ=10°)
Meta: (H=4, θ=0°)
Método: búsqueda en anchura (BFS), explorando ambos sentidos y rotación.
Camino encontrado con 6 movimientos:
 0. Inicio -> (H=0, θ=10°)
 1. Avanzar +1 -> (H=1, θ=10°)
 2. Avanzar +1 -> (H=2, θ=10°)
 3. Avanzar +1 -> (H=3, θ=10°)
 4. Avanzar +1 -> (H=4, θ=10°)
 5. Rotar -5° -> (H=4, θ=5°)
 6. Rotar -5° -> (H=4, θ=0°)
fede@MacBook-Pro-de-fede TP2 % javac codigo/BusquedaHeuristica.java
fede@MacBook-Pro-de-fede TP2 % java -cp codigo BusquedaHeuristica
=== Búsqueda heurística ===
Estado inicial: (H=0, θ=10°)
Meta: (H=4, θ=0°)
Método: A* usando heurística de distancia estimada.
Función heurística = |ΔH| + |Δθ|/5.
Camino encontrado con 6 movimientos:
 0. Inicio -> (H=0, θ=10°) (g=0, f=6.0)
 1. Avanzar +1 -> (H=1, θ=10°) (g=1, f=6.0)
 2. Avanzar +1 -> (H=2, θ=10°) (g=2, f=6.0)
 3. Rotar -5° -> (H=2, θ=5°) (g=3, f=6.0)
 4. Avanzar +1 -> (H=3, θ=5°) (g=4, f=6.0)
 5. Rotar -5° -> (H=3, θ=0°) (g=5, f=6.0)
 6. Avanzar +1 -> (H=4, θ=0°) (g=6, f=6.0)
