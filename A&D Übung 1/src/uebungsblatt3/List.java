package uebungsblatt3;

/**
 * Überschrift: Beschreibung: Copyright: Copyright (c) 2002 Organisation:
 * 
 * @author
 * @version 1.0
 */

public interface List {

	public int first();

	public int end();

	public int previous(int current);

	public int next(int current);

	public void insert(int position, Object element);

	public void remove(int position);

	public int find(Object o);

	public Object elementAt(int position);

	public boolean isEmpty();
}