public class main {
    public enum Apple { FUJI, PIPPIN, GRANNY_SMITH}
    public enum Orange {NAVEL, TEMPLE, BLOOD}

    // Tipo de enum com dados e comportamento
    public enum Planet {
        MERCURY(3.302e+23, 2.439e6),
        VENUS(4.869e+24, 6.052e6),
        EARTH(5.975e+24, 6.378e6);

        private final double mass;
        private final double radius;
        private final double surfaceGravity;

        // constante gravitacional universal em m^3 / kg s^2
        private static final double G = 6.67300E-11;

        // Construtor
        Planet(double mass, double radius) {
            this.mass = mass;
            this.radius = radius;
            surfaceGravity = G * mass / (radius * radius);
        }

        public double mass(){
            return mass;
        }

        public double radius(){
            return radius;
        }

        public double surfaceGravity(){
            return surfaceGravity;
        }

        public double surfaceWeight(double mass){
            return mass * surfaceGravity;
        }
    }

    // tipo de enum que faz switch do próprio valor, "questionavel";
    public enum Operation {
        PLUS, MINUS, TIMES, DIVIDE;
        // Operações aritméticas representada pelas constantes
        public double apply(double x, double y) throws Exception {
            switch (this){
                case PLUS -> {
                    return x + y;
                }
                case MINUS -> {
                    return  x - y;
                }
                case TIMES -> {
                    return x * y;
                }
                case DIVIDE -> {
                    return x / y;
                }
            }
            throw new Exception("Unknown op: "+ this);
        }
    }

    // Tipo enum com implementações de métodos especificos para constantes
    public enum ImpOperation{
        PLUS {
            @Override
            public double apply(double x, double y) {
                return x + y;
            }
        },
        MINUS {
            @Override
            public double apply(double x, double y) {
                return x - y;
            }
        },
        TIMES {
            @Override
            public double apply(double x, double y) {
                return x * y;
            }
        },
        DIVIDE {
            @Override
            public double apply(double x, double y) {
                return x / y;
            }
        };
        public abstract double apply(double x, double y);
    }


    public static void main(String[] args){
        double earthWeigth =  23.54;//Double.parseDouble(args[0]);
        double mass = earthWeigth / Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values()){
            System.out.printf("Weigth on %s is %f%n", p, p.surfaceWeight(mass));
        }
        System.out.println(ImpOperation.MINUS.apply(8, 3));
    }

}
