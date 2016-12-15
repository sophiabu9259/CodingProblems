package lcArraysLinkedListsStrings;
/**
 * (\\s*)[+-]?((\\.\\d+)|(\\d+(\\.\\d*)?))([Ee][+-]?\\d+)?(\\s*)
 * spaces |sign (once or never)| dot with one or more digits or at least one digit, [OPTIONAL ONCE OR NO dot, at least zero digits]| [OPTIONAL ONCE OR NO [MUST 1:eE] [OPTIONAL 1or0 :+-][MUST 1orN: digits] |spaces
 * @author Xuechao
 *
 */
public class ValidNumber {
	public boolean validNumber (String input) {
		return input.matches("(\\s*)[-+]?(\\.\\d+)|(\\d+(\\.(\\d+)?)?)([Ee][+-]?\\d+)?(\\s*)");
	}
}
