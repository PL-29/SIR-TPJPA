import { Pipe, PipeTransform } from '@angular/core';

import { Home } from './home/home.model';

@Pipe({
  name: 'FilterHome',
  pure: false
})
export class FilterHome implements PipeTransform {
  transform(items: Home[], filter: Home): Home[] {
    if (!items || !filter) {
      return items;
    }
    // filter items array, items which match and return true will be kept, false will be filtered out
    return items.filter((item: Home) => this.applyFilter(item, filter));
  }

  /**
   * Perform the filtering.
   *
   * @param {Book} book The book to compare to the filter.
   * @param {Book} filter The filter to apply.
   * @return {boolean} True if book satisfies filters, false if not.
   */
  applyFilter(home: Home, filter: Home): boolean {
    if(filter.idHome && filter.idHome != home.idHome){
      return false;
    }
    return true;
  }
}
