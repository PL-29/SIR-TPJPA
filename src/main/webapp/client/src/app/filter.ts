import { Pipe, PipeTransform } from '@angular/core';

import { PersonComponent } from './person';

@Pipe({
    name: 'FilterPersonName',
    pure: false
})
export class FilterPersonName implements PipeTransform {
    transform(items: PersonComponent[], name: PersonComponent): PersonComponent[] {
        if (!items || !filter) {
            return items;
        }
        // filter items array, items which match and return true will be kept, false will be filtered out
        return items.filter((item: PersonComponent) => this.applyFilter(item, filter));
    }

    /**
     * Perform the filtering.
     *
     * @param {Book} book The book to compare to the filter.
     * @param {Book} filter The filter to apply.
     * @return {boolean} True if book satisfies filters, false if not.
     */
    applyFilter(book: PersonComponent, filter: PersonComponent): boolean {
        if (filter.name && book.name.toLowerCase().indexOf(filter.name.toLowerCase()) === -1) {
            return false;
        }
        return true;
    }
}
