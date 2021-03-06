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
package mage.sets.worldwake;

import java.util.UUID;

import mage.constants.CardType;
import mage.constants.Rarity;
import mage.MageInt;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.condition.common.EquippedSourceCondition;
import mage.abilities.decorator.ConditionalContinuousEffect;
import mage.abilities.effects.common.continuous.BoostSourceEffect;
import mage.abilities.effects.common.continuous.GainAbilitySourceEffect;
import mage.abilities.keyword.FlyingAbility;
import mage.cards.CardImpl;
import mage.constants.Duration;
import mage.constants.Zone;

/**
 *
 * @author Loki
 */
public class KitesailApprentice extends CardImpl {

    private static final String rule1 = "As long as {this} is equipped, it gets +1/+1";
    private static final String rule2 = "As long as {this} is equipped, it has flying";

    public KitesailApprentice(UUID ownerId) {
        super(ownerId, 10, "Kitesail Apprentice", Rarity.COMMON, new CardType[]{CardType.CREATURE}, "{W}");
        this.expansionSetCode = "WWK";
        this.subtype.add("Kor");
        this.subtype.add("Soldier");

        this.color.setWhite(true);
        this.power = new MageInt(1);
        this.toughness = new MageInt(1);

        ConditionalContinuousEffect effect1 = new ConditionalContinuousEffect(new BoostSourceEffect(1, 1, Duration.WhileOnBattlefield), EquippedSourceCondition.getInstance(), rule1);
        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, effect1));
        ConditionalContinuousEffect effect2 = new ConditionalContinuousEffect(new GainAbilitySourceEffect(FlyingAbility.getInstance()), EquippedSourceCondition.getInstance(), rule2);
        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, effect2));
    }

    public KitesailApprentice(final KitesailApprentice card) {
        super(card);
    }

    @Override
    public KitesailApprentice copy() {
        return new KitesailApprentice(this);
    }
}
