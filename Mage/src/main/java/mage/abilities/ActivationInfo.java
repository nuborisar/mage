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
package mage.abilities;

import java.util.UUID;
import mage.game.Game;

/**
 * The ActivationInfo class holds the information how often an ability of an
 * object was activated during a turn. It handles the check, if the object is
 * still the same, so for example if a permanent left battlefield and returns,
 * the counting of activations happens for each object.
 *
 * @author LevelX2
 */
public class ActivationInfo {

    protected int turnNum;
    protected int activationCounter;

    public static ActivationInfo getInstance(Game game, UUID sourceId) {
        return ActivationInfo.getInstance(game, sourceId, game.getState().getZoneChangeCounter(sourceId));
    }

    public static ActivationInfo getInstance(Game game, UUID sourceId, int zoneChangeCounter) {
        String key = "ActivationInfo" + sourceId.toString() + zoneChangeCounter;
        ActivationInfo activationInfo = (ActivationInfo) game.getState().getValue(key);
        if (activationInfo == null) {
            activationInfo = new ActivationInfo(game);
            game.getState().setValue(key, activationInfo);
        }
        return activationInfo;
    }

    protected ActivationInfo(Game game) {
        this.turnNum = game.getTurnNum();
        this.activationCounter = 0;
    }

    public void addActivation(Game game) {
        if (game.getTurnNum() != turnNum) {
            activationCounter = 1;
            turnNum = game.getTurnNum();
        } else {
            activationCounter++;
        }
    }

    public int getActivationCounter() {
        return activationCounter;
    }
}
