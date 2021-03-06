/**
 *
 * Copyright 2011-2017 Xiaofei
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package xiaofei.library.zlang;

/**
 * Created by Xiaofei on 2017/9/21.
 */

class OprAdapterFactory {
    static OprAdapter getInstance(Opr opr) {
        switch (opr) {
            case NEGATIVE:
                return NegativeAdapter.INSTANCE;
            case PLUS:
                return PlusAdapter.INSTANCE;
            case MINUS:
                return MinusAdapter.INSTANCE;
            case TIMES:
                return TimesAdapter.INSTANCE;
            case DIVIDE:
                return DivideAdapter.INSTANCE;
            case EQUAL:
                return EqualAdapter.INSTANCE;
            case NOT_EQUAL:
                return NotEqualAdapter.INSTANCE;
            case LESS:
                return LessAdapter.INSTANCE;
            case LESS_EQUAL:
                return LessEqualAdapter.INSTANCE;
            case GREATER:
                return GreaterAdapter.INSTANCE;
            case GREATER_EQUAL:
                return GreaterEqualAdapter.INSTANCE;
            case NOT:
                return NotAdapter.INSTANCE;
            case AND:
                return AndAdapter.INSTANCE;
            case OR:
                return OrAdapter.INSTANCE;
            default:
                throw new IllegalArgumentException();
        }
    }

    //boolean, byte, char, short, int, long, float, and double

    private static class NegativeAdapter implements OprAdapter {
        static final NegativeAdapter INSTANCE = new NegativeAdapter();
        private NegativeAdapter() {}

        @Override
        public int getOperandNumber() {
            return 1;
        }

        @Override
        public Object operate(Object[] stack, int start) {
            Object operand = stack[start];
            if (operand == null) {
                throw new NullPointerException("Null is not allowed.");
            }
            if (operand instanceof Byte) {
                return -(byte) operand;
            } else if (operand instanceof Character) {
                return -(char) operand;
            } else if (operand instanceof Short) {
                return -(short) operand;
            } else if (operand instanceof Integer) {
                return -(int) operand;
            } else if (operand instanceof Long) {
                return -(long) operand;
            } else if (operand instanceof Float) {
                return -(float) operand;
            } else if (operand instanceof Double) {
                return -(double) operand;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private static class PlusAdapter implements OprAdapter {
        static final PlusAdapter INSTANCE = new PlusAdapter();
        private PlusAdapter() {}

        @Override
        public int getOperandNumber() {
            return 2;
        }

        @Override
        public Object operate(Object[] stack, int start) {
            Object o1 = stack[start], o2 = stack[start + 1];
            if (o1 == null && o2 == null) {
                throw new NullPointerException("Null is not allowed.");
            }
            if (o1 instanceof String) {
                return (String) o1 + o2;
            }
            if (o2 instanceof String) {
                return o1 + (String) o2;
            }
            Class<?> clazz = PrimitiveConverter.get(o1, o2);
            if (clazz == Byte.class) {
                return (byte) o1 + (byte) o2;
            } else if (clazz == Character.class) {
                return (char) o1 + (char) o2;
            } else if (clazz == Short.class) {
                return (short) o1 + (short) o2;
            } else if (clazz == Integer.class) {
                return (int) o1 + (int) o2;
            } else if (clazz == Long.class) {
                return (long) o1 + (long) o2;
            } else if (clazz == Float.class) {
                return (float) o1 + (float) o2;
            } else if (clazz == Double.class) {
                return (double) o1 + (double) o2;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private static class MinusAdapter implements OprAdapter {

        static final MinusAdapter INSTANCE = new MinusAdapter();

        private MinusAdapter() {}

        @Override
        public int getOperandNumber() {
            return 2;
        }

        @Override
        public Object operate(Object[] stack, int start) {
            Object o1 = stack[start], o2 = stack[start + 1];
            if (o1 == null || o2 == null) {
                throw new NullPointerException("Null is not allowed.");
            }
            Class<?> clazz = PrimitiveConverter.get(o1, o2);
            if (clazz == Byte.class) {
                return (byte) o1 - (byte) o2;
            } else if (clazz == Character.class) {
                return (char) o1 - (char) o2;
            } else if (clazz == Short.class) {
                return (short) o1 - (short) o2;
            } else if (clazz == Integer.class) {
                return (int) o1 - (int) o2;
            } else if (clazz == Long.class) {
                return (long) o1 - (long) o2;
            } else if (clazz == Float.class) {
                return (float) o1 - (float) o2;
            } else if (clazz == Double.class) {
                return (double) o1 - (double) o2;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private static class TimesAdapter implements OprAdapter {
        static final TimesAdapter INSTANCE = new TimesAdapter();
        private TimesAdapter() {}

        @Override
        public int getOperandNumber() {
            return 2;
        }

        @Override
        public Object operate(Object[] stack, int start) {
            Object o1 = stack[start], o2 = stack[start + 1];
            if (o1 == null || o2 == null) {
                throw new NullPointerException("Null is not allowed.");
            }
            Class<?> clazz = PrimitiveConverter.get(o1, o2);
            if (clazz == Byte.class) {
                return (byte) o1 * (byte) o2;
            } else if (clazz == Character.class) {
                return (char) o1 * (char) o2;
            } else if (clazz == Short.class) {
                return (short) o1 * (short) o2;
            } else if (clazz == Integer.class) {
                return (int) o1 * (int) o2;
            } else if (clazz == Long.class) {
                return (long) o1 * (long) o2;
            } else if (clazz == Float.class) {
                return (float) o1 * (float) o2;
            } else if (clazz == Double.class) {
                return (double) o1 * (double) o2;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private static class DivideAdapter implements OprAdapter {
        static final DivideAdapter INSTANCE = new DivideAdapter();
        private DivideAdapter() {}

        @Override
        public int getOperandNumber() {
            return 2;
        }

        @Override
        public Object operate(Object[] stack, int start) {
            Object o1 = stack[start], o2 = stack[start + 1];
            if (o1 == null || o2 == null) {
                throw new NullPointerException("Null is not allowed.");
            }
            Class<?> clazz = PrimitiveConverter.get(o1, o2);
            if (clazz == Byte.class) {
                return (byte) o1 / (byte) o2;
            } else if (clazz == Character.class) {
                return (char) o1 / (char) o2;
            } else if (clazz == Short.class) {
                return (short) o1 / (short) o2;
            } else if (clazz == Integer.class) {
                return (int) o1 / (int) o2;
            } else if (clazz == Long.class) {
                return (long) o1 / (long) o2;
            } else if (clazz == Float.class) {
                return (float) o1 / (float) o2;
            } else if (clazz == Double.class) {
                return (double) o1 / (double) o2;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private static class EqualAdapter implements OprAdapter {
        static final EqualAdapter INSTANCE = new EqualAdapter();
        private EqualAdapter() {}

        @Override
        public int getOperandNumber() {
            return 2;
        }

        @Override
        public Object operate(Object[] stack, int start) {
            return stack[start] == stack[start + 1];
        }
    }

    private static class NotEqualAdapter implements OprAdapter {
        static final NotEqualAdapter INSTANCE = new NotEqualAdapter();
        private NotEqualAdapter() {}

        @Override
        public int getOperandNumber() {
            return 2;
        }

        @Override
        public Object operate(Object[] stack, int start) {
            return stack[start] != stack[start + 1];
        }
    }

    private static class LessAdapter implements OprAdapter {
        static final LessAdapter INSTANCE = new LessAdapter();
        private LessAdapter() {}

        @Override
        public int getOperandNumber() {
            return 2;
        }

        @Override
        public Object operate(Object[] stack, int start) {
            Object o1 = stack[start], o2 = stack[start + 1];
            if (o1 == null || o2 == null) {
                throw new NullPointerException("Null is not allowed.");
            }
            Class<?> clazz = PrimitiveConverter.get(o1, o2);
            if (clazz == Byte.class) {
                return (byte) o1 < (byte) o2;
            } else if (clazz == Character.class) {
                return (char) o1 < (char) o2;
            } else if (clazz == Short.class) {
                return (short) o1 < (short) o2;
            } else if (clazz == Integer.class) {
                return (int) o1 < (int) o2;
            } else if (clazz == Long.class) {
                return (long) o1 < (long) o2;
            } else if (clazz == Float.class) {
                return (float) o1 < (float) o2;
            } else if (clazz == Double.class) {
                return (double) o1 < (double) o2;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private static class LessEqualAdapter implements OprAdapter {
        static final LessEqualAdapter INSTANCE = new LessEqualAdapter();
        private LessEqualAdapter() {}

        @Override
        public int getOperandNumber() {
            return 2;
        }

        @Override
        public Object operate(Object[] stack, int start) {
            Object o1 = stack[start], o2 = stack[start + 1];
            if (o1 == null || o2 == null) {
                throw new NullPointerException("Null is not allowed.");
            }
            Class<?> clazz = PrimitiveConverter.get(o1, o2);
            if (clazz == Byte.class) {
                return (byte) o1 <= (byte) o2;
            } else if (clazz == Character.class) {
                return (char) o1 <= (char) o2;
            } else if (clazz == Short.class) {
                return (short) o1 <= (short) o2;
            } else if (clazz == Integer.class) {
                return (int) o1 <= (int) o2;
            } else if (clazz == Long.class) {
                return (long) o1 <= (long) o2;
            } else if (clazz == Float.class) {
                return (float) o1 <= (float) o2;
            } else if (clazz == Double.class) {
                return (double) o1 <= (double) o2;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private static class GreaterAdapter implements OprAdapter {
        static final GreaterAdapter INSTANCE = new GreaterAdapter();
        private GreaterAdapter() {}

        @Override
        public int getOperandNumber() {
            return 2;
        }

        @Override
        public Object operate(Object[] stack, int start) {
            Object o1 = stack[start], o2 = stack[start + 1];
            if (o1 == null || o2 == null) {
                throw new NullPointerException("Null is not allowed.");
            }
            Class<?> clazz = PrimitiveConverter.get(o1, o2);
            if (clazz == Byte.class) {
                return (byte) o1 > (byte) o2;
            } else if (clazz == Character.class) {
                return (char) o1 > (char) o2;
            } else if (clazz == Short.class) {
                return (short) o1 > (short) o2;
            } else if (clazz == Integer.class) {
                return (int) o1 > (int) o2;
            } else if (clazz == Long.class) {
                return (long) o1 > (long) o2;
            } else if (clazz == Float.class) {
                return (float) o1 > (float) o2;
            } else if (clazz == Double.class) {
                return (double) o1 > (double) o2;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private static class GreaterEqualAdapter implements OprAdapter {
        static final GreaterEqualAdapter INSTANCE = new GreaterEqualAdapter();
        private GreaterEqualAdapter() {}

        @Override
        public int getOperandNumber() {
            return 2;
        }

        @Override
        public Object operate(Object[] stack, int start) {
            Object o1 = stack[start], o2 = stack[start + 1];
            if (o1 == null || o2 == null) {
                throw new NullPointerException("Null is not allowed.");
            }
            Class<?> clazz = PrimitiveConverter.get(o1, o2);
            if (clazz == Byte.class) {
                return (byte) o1 >= (byte) o2;
            } else if (clazz == Character.class) {
                return (char) o1 >= (char) o2;
            } else if (clazz == Short.class) {
                return (short) o1 >= (short) o2;
            } else if (clazz == Integer.class) {
                return (int) o1 >= (int) o2;
            } else if (clazz == Long.class) {
                return (long) o1 >= (long) o2;
            } else if (clazz == Float.class) {
                return (float) o1 >= (float) o2;
            } else if (clazz == Double.class) {
                return (double) o1 >= (double) o2;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private static class NotAdapter implements OprAdapter {
        static final NotAdapter INSTANCE = new NotAdapter();
        private NotAdapter() {}

        @Override
        public int getOperandNumber() {
            return 1;
        }

        @Override
        public Object operate(Object[] stack, int start) {
            Object operand = stack[start];
            if (operand instanceof Boolean) {
                return !(boolean) operand;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private static class AndAdapter implements OprAdapter {
        static final AndAdapter INSTANCE = new AndAdapter();
        private AndAdapter() {}

        @Override
        public int getOperandNumber() {
            return 2;
        }

        @Override
        public Object operate(Object[] stack, int start) {
            Object o1 = stack[start], o2 = stack[start + 1];
            if (o1 instanceof Boolean && o2 instanceof Boolean) {
                return (boolean) o1 && (boolean) o2;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private static class OrAdapter implements OprAdapter {
        static final OrAdapter INSTANCE = new OrAdapter();
        private OrAdapter() {}

        @Override
        public int getOperandNumber() {
            return 2;
        }

        @Override
        public Object operate(Object[] stack, int start) {
            Object o1 = stack[start], o2 = stack[start + 1];
            if (o1 instanceof Boolean && o2 instanceof Boolean) {
                return !(boolean) o1 || (boolean) o2;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
}
