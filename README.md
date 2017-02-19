# MemeFilter

Fed up of your social media feed being full of trite memes?

Wish there was service to reveal the subtext of the meme?

Try MemeFilter!

As an example, the following quote (most often mis-attributed to Marilyn Monroe) often appears:
"If you can't handle me at my worst, you don't deserve me at my best"

The subtext, beneath this quote is more along the lines of:
"If you won't put up with me when I mistreat you, you don't deserve me"

This is a REST service to translate from the next in the meme, to the real meaning.

There are 2 resources available.
1 for translating plain text, the other for parsing text from an image and returning a new image with the 'real' text.

Regexes are used to match the input to allow for variations on the meme.

## Work in progress

* Database of quotes to meanings is currently hard-coded
  * More examples needed
* Text translation endpoint is implemented
* Image translation is only half implemented
  * OCR is performed using Tesseract but it turns out the quality isn't great
  * Alternative is to call out to a 3rd party service that's better at doing OCR
  * Second stage of creating a new image needs implementing
* Service needs a home...

## Technologies Used

* SpringBoot
* Swagger
* AssertJ
* Tesseract
