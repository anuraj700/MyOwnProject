package com.anuraj.custom;

public class HashMapCustom<K, V> {

	static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;

		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	private Entry<K, V>[] table;
	private int capacity = 4;

	@SuppressWarnings("unchecked")
	public HashMapCustom() {
		table = new Entry[capacity];
	}

	private int hash(K key) {
		return Math.abs(key.hashCode()) % capacity;
	}

	public void put(K newKey, V data) {

		if (newKey == null) {
			return;
		}

		Entry<K, V> newEntry = new Entry<K, V>(newKey, data, null);

		int hash = hash(newKey);
		if (table[hash] == null) {
			table[hash] = newEntry;
		} else {
			Entry<K, V> previous = null;
			Entry<K, V> current = table[hash];

			while (current != null) {
				if (current.key.equals(newKey)) {
					if (previous == null) {
						newEntry.next = current.next;
						table[hash] = newEntry;
						return;
					} else {
						newEntry.next = current.next;
						previous.next = newEntry;
						return;
					}
				}

				previous = current;
				current = current.next;
			}
			previous.next = newEntry;

		}

	}

	public V get(K key) {
		int hash = hash(key);
		if (table[hash] == null) {
			return null;
		} else {
			Entry<K, V> temp = table[hash];
			while (temp != null) {
				if (temp.key.equals(key)) {
					return temp.value;
				}
				temp = temp.next;
			}
		}
		return null;
	}

	public boolean remove(K deleteKey) {

		int hash = hash(deleteKey);
		if (table[hash] == null) {
			return false;
		} else {
			Entry<K, V> previous = null;
			Entry<K, V> current = table[hash];

			while (current != null) {

				if (current.key.equals(deleteKey)) {
					if (previous == null) {
						table[hash] = current.next;
						return true;
					} else {
						previous.next = current.next;
						return true;
					}
				}

				previous = current;
				current = current.next;
			}
		}

		return false;
	}

	public void display() {
		for(int i=0;i<capacity;i++){
			if(table[i]!= null){
				Entry<K,V> entry=table[i];
				while(entry!=null){
					System.out.print("{"+entry.key+"="+entry.value+"} ");
					entry=entry.next;
				}
			}
		}
	}
}
