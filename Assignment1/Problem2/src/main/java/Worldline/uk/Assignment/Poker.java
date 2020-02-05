package Worldline.uk.Assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;



/**
 * @author arjund
 *
 */
/**
 * @author arjund
 *
 */
public class Poker {

	
   final static Logger logger = Logger.getLogger(Poker.class);
	private static final long FOUR_OF_A_KIND = cardCode("2H") | cardCode("2C") | cardCode("2S") | cardCode("2D");
	private static final long FLUSH_MASK = cardCode("2H") | cardCode("3H") | cardCode("4H") | cardCode("5H")
			| cardCode("6H");
	private static final long ROYAL_FLUSH_MASK = cardCode("TH") | cardCode("JH") | cardCode("QH") | cardCode("KH")
			| cardCode("AH");

	

	/**
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void startGame() {

		logger.info("inside start Game Method");

		File inputFile = new File("./src/main/resources/poker.txt");
		File outputFile = new File("./output.txt");

		logger.info("Input and Output File are :" + inputFile + " : " + outputFile);

		assert(inputFile.canRead());

		int result = 0;
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(inputFile));
			FileWriter out = new FileWriter(outputFile);
			String line;
			try {
				while (null != (line = in.readLine())) {
					long hands[] = parseHands(line);
					if (winner(hands) == 1) {
						result++;
						logger.info("Player 1 Wins :" + result);
					}

					out.write("Player 1 win :" + String.valueOf(result) + " hands");

				}
			} catch (IOException e) {
				logger.error(e);
			}
		} catch (Exception e) {
			logger.error(e);
		}

	}

	/**
	 * @param line
	 * @return Long array with bitwise value for both the hands stored in
	 *         bitwise value.
	 */
	private static long[] parseHands(String line) {
		logger.info("inside parseHands Method");
		String[] cards = line.split(" ");
		long[] r = new long[2];
		for (int card = 0; card < 10; card++) {
			r[card / 5] |= cardCode(cards[card]);
		}
		logger.info("After Bitwise operation :" + r[0] + " : " + r[1]);
		return r;
	}

	/**
	 * @param hands
	 * @return int
	 * 
	 *         This method iteratively checks for all possible combinations The
	 *         values of the outcome of the hand are stored in Value 1 and Value
	 *         2
	 * 
	 */
	/**
	 * @param hands
	 * @return int 1 if player 1 Wins
	 */
	private static int winner(long[] hands) {
		logger.info("inside winner Method" + hands[0] + hands[1]);
		boolean booleanValue = royalFlush(hands[0]);
		boolean booleanValue2 = royalFlush(hands[1]);
		int value1, value2;

		if (booleanValue && !booleanValue2) {
			return 1;
		} else if (booleanValue2 && !booleanValue) {
			return 2;
		} else if (booleanValue & booleanValue2) {
			return 0;
		}

		value1 = straightFlush(hands[0]);
		value2 = straightFlush(hands[1]);

		if (value1 + value2 != 0) {
			return winner(value1, value2, hands);
		}

		value1 = fourOfAKind(hands[0]);
		value2 = fourOfAKind(hands[1]);

		if (value1 + value2 != 0) {
			return winner(value1, value2, hands);
		}

		value1 = fullHouse(hands[0]);
		value2 = fullHouse(hands[1]);

		if (value1 + value2 != 0) {
			return winner(value1, value2, hands);
		}

		value1 = flush(hands[0]);
		value2 = flush(hands[1]);

		if (value1 + value2 != 0) {
			return winner(value1, value2, hands);
		}

		value1 = straight(hands[0]);
		value2 = straight(hands[1]);

		if (value1 + value2 != 0) {
			return winner(value1, value2, hands);
		}

		value1 = threeOfAKind(hands[0]);
		value2 = threeOfAKind(hands[1]);

		if (value1 + value2 != 0) {
			return winner(value1, value2, hands);
		}

		value1 = doublePairs(hands[0]);
		value2 = doublePairs(hands[1]);

		if (value1 + value2 != 0) {
			return winner(value1, value2, hands);
		}

		value1 = onePair(hands[0]);
		value2 = onePair(hands[1]);

		if (value1 + value2 != 0) {
			return winner(value1, value2, hands);
		}

		return playerWithHigherCards(hands);
	}

	/**
	 * @param hand
	 * @return
	 * 
	 * 		Looks for stright card
	 */

	private static int straight(long hand) {
		logger.info("inside straigh Method" + hand);
		int value = 2;
		long slot;

		while (0 == (hand >> 4 * (value - 2) & 15)) {
			value++;
		}

		for (int i = 2; i <= 5; i++) {
			value++;
			slot = hand >> 4 * (value - 2) & 15;

			if (slot == 0) {
				return 0;
			}
		}

		return value;
	}

	/**
	 * @param hand
	 * @return int looking for Pairs
	 */
	private static int onePair(long hand) {
		logger.info("inside onePair Method" + hand);
		if (threeOfAKind(hand) != 0 || doublePairs(hand) != 0) {
			return 0;
		}

		for (int value = 14; value >= 2; value--) {
			long slot = hand >> 4 * (value - 2) & 15;

			if (Long.bitCount(slot) == 2) {
				return value;
			}
		}

		return 0;
	}

	/**
	 * @param hand
	 * @return
	 * 
	 * 		loking for next high cards
	 */
	private static int highCard(long hand) {

		logger.info("inside highCard Method" + hand);
		int result = 0;

		for (int value = 14; value >= 2; value--) {
			long slot = (hand >> 4 * (value - 2)) & 15;

			if (slot > 0) {
				result = result * 16 + value;
			}
		}

		return result;
	}

	/**
	 * @param hands
	 * @return int value
	 * 
	 *         This is a deciding factor in case you have a tie .
	 * 
	 * 
	 */
	private static int playerWithHigherCards(long[] hands) {
		logger.info("inside playerWithHigherCards  method " + hands[0] + hands[1]);
		switch (Integer.compare(highCard(hands[0]), highCard(hands[1]))) {
		case -1:
			return 2;
		case 1:
			return 1;
		default:
			return 0;
		}
	}

	/**
	 * @param value1
	 * @param value2
	 * @param hands
	 * @return int
	 * 
	 *         Method to determine the winner
	 * 
	 */
	private static int winner(int value1, int value2, long[] hands) {
		logger.info("inside winner method" + value1 + value2);
		if (value1 > value2) {
			return 1;
		} else if (value1 < value2) {
			return 2;
		} else {
			return playerWithHigherCards(hands);
		}
	}

	/**
	 * @param card
	 * @return Breaking the cards into bitwise representation.
	 */
	private static long cardCode(String card) {

		logger.info("inside cardCode " + card);
		String suitTexts = "HCSD";
		int suitCode = suitTexts.indexOf(card.charAt(1));
		final char C = card.charAt(0);
		int valueCode = "TJQKA".indexOf(C);
		int value = (valueCode == -1) ? (C - '0') - 2 : 8 + valueCode;

		return 1L << (4 * value + suitCode);
	}

	/**
	 * 
	 * @param hand
	 *            return boolean using a Mask to find Royal Flush
	 * 
	 */
	private static boolean royalFlush(long hand) {

		logger.info("inside royalFlush " + hand);
		return hand == ROYAL_FLUSH_MASK || hand == (ROYAL_FLUSH_MASK << 1) || hand == (ROYAL_FLUSH_MASK << 2)
				|| hand == (ROYAL_FLUSH_MASK << 3);
	}

	/**
	 * @param hand
	 * @return int
	 * 
	 *         using Bitwise Operator to find Flush
	 */
	private static int straightFlush(long hand) {

		logger.info("inside straightFlush " + hand);
		int value = 2;

		while (0 == (hand & 15)) {
			hand >>= 4;
			value++;
		}

		while (0 == (hand & 1)) {
			hand >>= 1;
		}

		return hand == FLUSH_MASK ? value : 0;
	}

	/**
	 * @param hand
	 * @return long
	 */
	private static int fourOfAKind(long hand) {

		logger.info("inside fourOfAKind " + hand);

		long mask = FOUR_OF_A_KIND;

		for (int value = 2; value <= 14; value++) {
			if (mask == (hand & mask)) {
				return value;
			}

			mask <<= 4;
		}

		return 0;
	}

	/**
	 * @param hand
	 * @return int to determine if the cards are full house or not .
	 */
	private static int fullHouse(long hand) {

		logger.info("inside fullHouse " + hand);
		int value3 = 0;
		int value2 = 0;
		int currentValue = 2;

		for (int i = 0; i < 2; i++) {
			while ((hand & 15) == 0) {
				currentValue++;
				hand >>= 4;
			}

			switch (Long.bitCount(hand & 15)) {
			case 2:
				value2 = currentValue;
				break;
			case 3:
				value3 = currentValue;
				break;
			default:
				return 0;
			}

			currentValue++;
			hand >>= 4;
		}

		if (value3 == 0 || value2 == 0) {
			return 0;
		}

		return 100 * value3 + value2;
	}

	/**
	 * @param hand
	 * @return
	 * 
	 * 		To determine if three of a kind is present or not
	 * 
	 */
	private static int threeOfAKind(long hand) {

		logger.info("inside threeOfAKind " + hand);

		for (int value = 2; value <= 14; value++) {
			long slot = hand >> 4 * (value - 2) & 15;

			if (slot == 0b0111 || slot == 0b1011 || slot == 0b1101 || slot == 0b1110) {
				return value;
			}
		}

		return 0;
	}

	/**
	 * @param hand
	 * @return to figure if you have double pairs or not.
	 * 
	 */
	private static int doublePairs(long hand) {
		logger.info("inside doublePairs " + hand);
		int pairs = 0;
		int resultValue = 0;

		for (int value = 14; value >= 2; value--) {
			long slot = hand >> 4 * (value - 2) & 15;

			if (Long.bitCount(slot) == 2) {
				resultValue = resultValue * 100 + value;
				pairs++;
			}
		}

		return pairs == 2 ? resultValue : 0;
	}

	/**
	 * @param hand
	 * @return int
	 * 
	 *         method to determine flush
	 */
	private static int flush(long hand) {
		logger.info("inside flush " + hand);
		int result = 0;
		int pot = 1;
		long check = 0;

		for (int value = 2; value <= 14; value++) {
			long slot = hand >> 4 * (value - 2) & 15;

			if (slot != 0) {
				result += value * pot;
				check = (check << 4) | slot;
				pot *= 16;
			}
		}

		while ((check & 1) == 0) {
			check >>= 1;
		}

		return (check == 0b00010001000100010001) ? result : 0;
	}

}
