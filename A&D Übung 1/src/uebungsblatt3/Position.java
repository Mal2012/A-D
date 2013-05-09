package uebungsblatt3;

/**
 * Überschrift: Beschreibung: Copyright: Copyright (c) 2002 Organisation:
 * 
 * @author
 * @version 1.0
 */

public interface Position {

	public Object retrieve();

	// Objekt an der aktuellen Position
	public Position current();

	// aktuelle Position
	public void next();

	// aktuelle Position auf die nächste setzen
	public boolean isPastEnd();

	// Ist aktuelle Position am Ende der Liste?
	public boolean equals(Position p);
	// Ist die aktuelle Position mit p gleich?

}