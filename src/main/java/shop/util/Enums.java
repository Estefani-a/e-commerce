package shop.util;

/* esta clase  contiene enums para los tipos y estados de carrito.*/

public class Enums {
    public enum CartType {
        COMUN("Común"),
        VIP("VIP"),
        FECHA_ESPECIAL("Fecha Especial");

        private final String displayName;

        CartType(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public String toString() {
            return displayName;
        }

        public static CartType fromString(String type) {
            return CartType.valueOf(type.toUpperCase());
        }
    }

    public enum CartState {
        ABIERTO("Abierto"),
        CERRADO("Cerrado");

        private final String displayName;

        CartState(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public String toString() {
            return displayName;
        }

        public static CartState fromString(String state) {
            return CartState.valueOf(state.toUpperCase());
        }
    }
}

