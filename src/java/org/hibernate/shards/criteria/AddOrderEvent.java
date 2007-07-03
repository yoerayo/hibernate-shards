/**
 * Copyright (C) 2007 Google Inc.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA
 */

package org.hibernate.shards.criteria;

import org.hibernate.criterion.Order;
import org.hibernate.Criteria;

/**
 * Event that allows an Order to be lazily added to a Criteria.
 * @see Criteria#addOrder(Order)
 * 
 * @author Max Ross <maxr@google.com>
 */
class AddOrderEvent implements CriteriaEvent {

  // the Order we're going to add when the event fires
  private final Order order;

  /**
   * Construct an AddOrderEvent
   *
   * @param order the Order we'll add when the event fires
   */
  public AddOrderEvent(Order order) {
    this.order = order;
  }

  public void onEvent(Criteria crit) {
    crit.addOrder(order);
  }
}