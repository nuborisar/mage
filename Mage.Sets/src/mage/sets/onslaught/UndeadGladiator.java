/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.sets.onslaught;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.condition.common.IsStepCondition;
import mage.abilities.costs.common.DiscardCardCost;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.decorator.ConditionalActivatedAbility;
import mage.abilities.effects.common.ReturnSourceFromGraveyardToHandEffect;
import mage.abilities.keyword.CyclingAbility;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.PhaseStep;
import mage.constants.Rarity;
import mage.constants.Zone;

/**
 *
 * @author fireshoes
 */
public class UndeadGladiator extends CardImpl {

    public UndeadGladiator(UUID ownerId) {
        super(ownerId, 178, "Undead Gladiator", Rarity.RARE, new CardType[]{CardType.CREATURE}, "{1}{B}{B}");
        this.expansionSetCode = "ONS";
        this.subtype.add("Zombie");
        this.subtype.add("Barbarian");
        this.power = new MageInt(3);
        this.toughness = new MageInt(1);

        // {1}{B}, Discard a card: Return Undead Gladiator from your graveyard to your hand. Activate this ability only during your upkeep.
        Ability ability = new ConditionalActivatedAbility(Zone.GRAVEYARD, 
                new ReturnSourceFromGraveyardToHandEffect(), 
                new ManaCostsImpl("{1}{B}"), 
                new IsStepCondition(PhaseStep.UPKEEP), null);
        ability.addCost(new DiscardCardCost());
        this.addAbility(ability);
        
        // Cycling {1}{B}
        this.addAbility(new CyclingAbility(new ManaCostsImpl("{1}{B}")));
    }

    public UndeadGladiator(final UndeadGladiator card) {
        super(card);
    }

    @Override
    public UndeadGladiator copy() {
        return new UndeadGladiator(this);
    }
}
