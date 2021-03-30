import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

export const AuthorValidator: ValidatorFn = (
  control: AbstractControl
): ValidationErrors | null => {
  const author = control.get('author');
  const title = control.get('title');
  if (!author.value.length) {
    return null;
  }

  return title.value.toLowerCase()
    .includes(author.value.toLowerCase()) ?
    { authorNameInEmail: true } : null;
};
