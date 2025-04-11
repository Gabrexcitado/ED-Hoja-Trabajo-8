import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class VectorHeapTest {

    private VectorHeap<Pacient> heap;

    // Método para inicializar un nuevo heap antes de cada prueba
    @Before
    public void setUp() {
        heap = new VectorHeap<>();
    }

    // Test de añadir un solo elemento
    @Test
    public void testAddSingleElement() {
        Pacient pacient = new Pacient("Pacient1", "dolor de panza", "A", "8:30");
        heap.add(pacient);
        assertEquals(pacient, heap.poll());
    }

    // Test de añadir varios elementos y eliminar el de mayor prioridad
    @Test
    public void testAddMultipleElements() {
        Pacient pacientFirst = new Pacient("Pacient1", "dolor de panza", "A", "8:30");
        Pacient pacientSecond = new Pacient("Pacient2", "dolor de cabeza", "B", "8:35");
        Pacient pacientThird = new Pacient("Pacient3", "fiebre", "C", "8:40");
        Pacient pacientFourth = new Pacient("Pacient4", "tos", "D", "8:45");

        heap.add(pacientThird);
        heap.add(pacientFirst);
        heap.add(pacientFourth);
        heap.add(pacientSecond);

        assertEquals(pacientFirst, heap.poll());
        assertEquals(pacientSecond, heap.poll());
        assertEquals(pacientThird, heap.poll());
        assertEquals(pacientFourth, heap.poll());
    }

    // Test de añadir y eliminar elementos en orden
    @Test
    public void testPollOnEmptyHeap() {
        assertNull(heap.poll());
    }

    // Test de agregar elementos de forma que la propiedad del heap se mantenga
    @Test
    public void testAddAndMaintainHeapOrder() {
        Pacient pacientFirst = new Pacient("Pacient1", "dolor de panza", "A", "8:30");
        Pacient pacientSecond = new Pacient("Pacient2", "dolor de cabeza", "A", "8:35");
        Pacient pacientThird = new Pacient("Pacient3", "fiebre", "C", "8:40");
        Pacient pacientFourth = new Pacient("Pacient4", "tos", "D", "8:45");
        
        heap.add(pacientThird);
        heap.add(pacientSecond);
        heap.add(pacientFourth);
        heap.add(pacientFirst);

        // Verificamos que el primer elemento extraído sea el de menor prioridad (el más pequeño)
        assertEquals(pacientFirst, heap.poll());
        assertEquals(pacientSecond, heap.poll());

    }

    // Test de agregar un solo elemento y luego verificar el comportamiento de poll
    @Test
    public void testAddAndPollSingleElement() {
        Pacient pacientFirst = new Pacient("Pacient1", "dolor de panza", "A", "8:30");
        heap.add(pacientFirst);
        assertEquals(pacientFirst, heap.poll());
        assertNull(heap.poll());
    }
}
