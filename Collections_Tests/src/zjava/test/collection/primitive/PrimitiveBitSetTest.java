package zjava.test.collection.primitive;

import static org.junit.Assert.*;

import org.junit.Test;

import zjava.collection.primitive.PrimitiveBitSet;

public class PrimitiveBitSetTest {

	@Test
	public void emptyIntSetSizeReturnsZero() {
		int set = 0;
		// PrimitiveBitSet.size(set);
		assertEquals(0, PrimitiveBitSet.size(set));
	}

	@Test // �������� ������ .size � ���������� ���� int
	public void intSetSizeCheck() {
		int set = 0;
		set = PrimitiveBitSet.add(set, 2);
		assertEquals(1, PrimitiveBitSet.size(set));
		set = PrimitiveBitSet.add(set, 2);
		assertEquals(1, PrimitiveBitSet.size(set));
		set = PrimitiveBitSet.add(set, 3);
		assertEquals(2, PrimitiveBitSet.size(set));
		set = PrimitiveBitSet.add(set, 31);
		assertEquals(3, PrimitiveBitSet.size(set));
		set = PrimitiveBitSet.add(set, 0);
		assertEquals(4, PrimitiveBitSet.size(set));
	}

	@Test // �������� ������ .size � ���������� ���� long
	public void longSetSizeCheck() {
		long set = 0;
		set = PrimitiveBitSet.add(set, 2);
		assertEquals(1, PrimitiveBitSet.size(set));
		set = PrimitiveBitSet.add(set, 2);
		assertEquals(1, PrimitiveBitSet.size(set));
		set = PrimitiveBitSet.add(set, 3);
		assertEquals(2, PrimitiveBitSet.size(set));
		set = PrimitiveBitSet.add(set, 63);
		assertEquals(3, PrimitiveBitSet.size(set));
		set = PrimitiveBitSet.add(set, 0);
		assertEquals(4, PrimitiveBitSet.size(set));
	}
	
	@Test // �������� ������ .contains
	public void intContainsCheck() {
		int set = 0;
		set = PrimitiveBitSet.add(set, 1); // ��������� �� ��������� ����� .contains � ��������� ������ ������������� ����� .add? �� ���������, �� ��-������� ����� �����.
		assertTrue(PrimitiveBitSet.contains(set, 1));
		set = PrimitiveBitSet.add(set, 2);
		assertFalse(PrimitiveBitSet.contains(set, 3));
	}
	
	@Test // �������� ������ .size � ���������� ���� int � � �������������� ������������� ��������
	public void intAddCheck() {
		int set = 0;
		set = PrimitiveBitSet.add(set, 1);
		assertEquals(1, PrimitiveBitSet.size(set));
		set = PrimitiveBitSet.add(set, 0);
		assertEquals(2, PrimitiveBitSet.size(set));
		set = PrimitiveBitSet.add(set, 31);
		assertEquals(3, PrimitiveBitSet.size(set));
		set = PrimitiveBitSet.add(set, -31);
		assertEquals(3, PrimitiveBitSet.size(set));	
	}

	@Test // �������� ������ .size � ���������� ���� long � � �������������� ������������� ��������
	public void longAddCheck() {
		long set = 0;
		set = PrimitiveBitSet.add(set, 1);
		assertEquals(1, PrimitiveBitSet.size(set));
		set = PrimitiveBitSet.add(set, 0);
		assertEquals(2, PrimitiveBitSet.size(set));
		set = PrimitiveBitSet.add(set, 63);
		assertEquals(3, PrimitiveBitSet.size(set));
		set = PrimitiveBitSet.add(set, -63);
		assertEquals(3, PrimitiveBitSet.size(set));// ����� True ������ ��� "-63" ������������� � "1", � "1" ��� ������������ � set-e.
	}
	
	@Test // �������� ������ .remove � ���������� ���� int
	public void intRemoveCheck() {
		int set = 0;
		set = PrimitiveBitSet.add(set, 0);
		set = PrimitiveBitSet.add(set, 1);
		set = PrimitiveBitSet.add(set, 2);
		set = PrimitiveBitSet.add(set, 12);
		set = PrimitiveBitSet.add(set, 31);
		set = PrimitiveBitSet.remove(set, 12);
		assertFalse(PrimitiveBitSet.contains(set, 12));
		set = PrimitiveBitSet.remove(set, 0);
		assertFalse(PrimitiveBitSet.contains(set, 0));
		set = PrimitiveBitSet.remove(set, 31);
		assertFalse(PrimitiveBitSet.contains(set, 31));
//		Boolean resultActual = PrimitiveBitSet.contains(set, 1);
//		Boolean resultExpected = true;
//		assertTrue(resultExpected = resultActual);
////		PrimitiveBitSet.contains(set, 1);
////		System.out.print(set);
	}

	@Test // �������� ������ .indexOf � ���������� ���� int
	public void intIndexOfCheck() {
		int set = 0;
		set = PrimitiveBitSet.add(set, 0);
		set = PrimitiveBitSet.add(set, 1);
		set = PrimitiveBitSet.add(set, 2);
		set = PrimitiveBitSet.add(set, 12);
		set = PrimitiveBitSet.add(set, 31);
		assertEquals(3, PrimitiveBitSet.indexOf(set, 12));
		assertEquals(0, PrimitiveBitSet.indexOf(set, 0));
		assertEquals(4, PrimitiveBitSet.indexOf(set, 31));
		assertEquals(3, PrimitiveBitSet.indexOf(set, 9));
	}

	@Test // �������� ������ .next � ���������� ���� int
	public void intNext() {
		int set = 0;
		set = PrimitiveBitSet.add(set, 0);
		set = PrimitiveBitSet.add(set, 1);
		set = PrimitiveBitSet.add(set, 2);
		set = PrimitiveBitSet.add(set, 12);
		set = PrimitiveBitSet.add(set, 31);
		assertEquals(1, PrimitiveBitSet.next(set, 0));
		assertEquals(2, PrimitiveBitSet.next(set, 1));
		assertEquals(31, PrimitiveBitSet.next(set, 12));
		assertEquals(31, PrimitiveBitSet.next(set, 31));
		assertEquals(12, PrimitiveBitSet.next(set, 7));
	}

	//``````````````Long related methods``````````````````````````````````````````````````````````
	
	
	@Test // �������� ������ .contains � ���������� ���� long
	public void longContainsCheck() {
		long set = 0;
		set = PrimitiveBitSet.add(set, 1); // ��������� �� ��������� ����� .contains � ��������� ������ ������������� ����� .add? �� ���������, �� ��-������� ����� �����.
		assertTrue(PrimitiveBitSet.contains(set, 1));
		set = PrimitiveBitSet.add(set, 2);
		assertFalse(PrimitiveBitSet.contains(set, 3));
		set = PrimitiveBitSet.add(set, 63); // ��������� �� ��������� ����� .contains � ��������� ������ ������������� ����� .add? �� ���������, �� ��-������� ����� �����.
		assertTrue(PrimitiveBitSet.contains(set, 63));
		set = PrimitiveBitSet.add(set, 62);
		assertFalse(PrimitiveBitSet.contains(set, 61));
		}
	
	
	//@Test // �������� ������ .add � ���������� ���� long � � �������������� ������������� ��������
		  //��� ����. ��. ���� public void longAddCheck() {
		
	
	
	@Test // �������� ������ .remove � ���������� ���� long
	public void longRemoveCheck() {
		long set = 0;
		set = PrimitiveBitSet.add(set, 0);
		set = PrimitiveBitSet.add(set, 1);
		set = PrimitiveBitSet.add(set, 2);
		set = PrimitiveBitSet.add(set, 12);
		set = PrimitiveBitSet.add(set, 31);
		set = PrimitiveBitSet.add(set, 63);
		set = PrimitiveBitSet.remove(set, 12);
		assertFalse(PrimitiveBitSet.contains(set, 12));
		set = PrimitiveBitSet.remove(set, 0);
		assertFalse(PrimitiveBitSet.contains(set, 0));
		set = PrimitiveBitSet.remove(set, 31);
		assertFalse(PrimitiveBitSet.contains(set, 31));
		set = PrimitiveBitSet.remove(set, 63);
		assertFalse(PrimitiveBitSet.contains(set, 63));
	}
	
	@Test // �������� ������ .indexOf � ���������� ���� long
	public void longIndexOfCheck() {
		long set = 0;
		set = PrimitiveBitSet.add(set, 0);
		set = PrimitiveBitSet.add(set, 1);
		set = PrimitiveBitSet.add(set, 2);
		set = PrimitiveBitSet.add(set, 12);
		set = PrimitiveBitSet.add(set, 31);
		set = PrimitiveBitSet.add(set, 63);
		assertEquals(3, PrimitiveBitSet.indexOf(set, 12));
		assertEquals(0, PrimitiveBitSet.indexOf(set, 0));
		assertEquals(4, PrimitiveBitSet.indexOf(set, 31));
		assertEquals(3, PrimitiveBitSet.indexOf(set, 9));
		assertEquals(5, PrimitiveBitSet.indexOf(set, 63));
	}
	
	@Test // �������� ������ .next � ���������� ���� long
	public void longNext() {
		long set = 0;
		set = PrimitiveBitSet.add(set, 0);
		set = PrimitiveBitSet.add(set, 1);
		set = PrimitiveBitSet.add(set, 2);
		set = PrimitiveBitSet.add(set, 12);
		set = PrimitiveBitSet.add(set, 31);
		set = PrimitiveBitSet.add(set, 63);
		assertEquals(1, PrimitiveBitSet.next(set, 0));
		assertEquals(2, PrimitiveBitSet.next(set, 1));
		assertEquals(31, PrimitiveBitSet.next(set, 12));
		assertEquals(63, PrimitiveBitSet.next(set, 31));
		assertEquals(12, PrimitiveBitSet.next(set, 7));
		assertEquals(63, PrimitiveBitSet.next(set, 60));
		assertEquals(63, PrimitiveBitSet.next(set, 63));
	}
	
}