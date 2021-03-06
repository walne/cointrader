package org.cryptocoinpartners.command;

import org.cryptocoinpartners.schema.Listing;
import org.cryptocoinpartners.schema.Market;

import java.util.*;


/**
 * @author Tim Olson
 */
@SuppressWarnings("UnusedDeclaration")
public class ListingsCommand extends CommandBase {

    public void run() {
        Set<String> symbols = new HashSet<>();
        for( Market market : Market.findAll() )
            symbols.add(market.getListing().getSymbol());
        List<String> sorted = new ArrayList<>(symbols);
        Collections.sort(sorted);
        out.printList(symbols);
    }


    public String getUsageHelp() { return "listings"; }
    public String getExtraHelp() { return "prints all listings available on at least one exchange"; }
}